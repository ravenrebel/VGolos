package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.dto.*;
import com.vgolos.VGolos.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultRepositoryImpl implements ResultRepository {

    private EntityManager em;

    @Autowired
    public ResultRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CandidateResult> getResultsByElectionIdAndMinPercentage(Long electionId, int minPercentage) {
        String queryString = "with all_votes as (select count(votes.id) as general_count, elections.id as election\n" +
                "                   from votes\n" +
                "                            join elections on elections.id = votes.election_id\n" +
                "                   where election_id = :electionId\n" +
                "                   group by election),\n" +
                "     results as (select first_name || ' ' || last_name || ' ' || fathers_name as candidate_name,\n" +
                "                        count(votes.id)                                       as votes_count,\n" +
                "                        cast(count(votes.id) as decimal) * 100 / general_count  as percents\n" +
                "                 from candidates\n" +
                "                          join citizens on citizens.id = candidates.citizen_id\n" +
                "                          join votes on votes.candidate_id = candidates.id\n" +
                "                          join elections on elections.id = votes.election_id\n" +
                "                          join all_votes on all_votes.election = elections.id\n" +
                "                 group by candidate_name, general_count)\n" +
                "select candidate_name, votes_count, percents\n" +
                "from results\n" +
                "where percents >= :minPercentage\n" +
                "order by percents desc";
        Query query = em.createNativeQuery(queryString);
        query.setParameter("electionId", electionId);
        query.setParameter("minPercentage", minPercentage);
        List<Object[]> resultList = query.getResultList();
        List<CandidateResult> result = new ArrayList<>();
        resultList.forEach(object -> {
            CandidateResult candidateResult = new CandidateResult();
            candidateResult.setName(object[0].toString());
            candidateResult.setVotesCount(Integer.valueOf(object[1].toString()));
            candidateResult.setPercents(Float.valueOf(object[2].toString()));
            result.add(candidateResult);
        });
        return result;
    }

    @Override
    public List<CandidateRegion> getWinnersInRegions(Long electionId) {
        String queryString = " with all_votes as (select count(votes.id) as general_count, candidates.id as candidate from votes\n" +
                "       join candidates on candidates.id = votes.candidate_id\n" +
        " group by candidate),\n" +
        " results_one as (select first_name || ' ' || last_name || ' ' || \n" +
        " fathers_name as candidate_name, candidate_id as  new_candidate_id\n" +
        " from candidates join citizens on citizens.id = candidates.citizen_id \n" +
                        " join votes on candidates.id = votes.candidate_id \n" +
                        " join elections on elections.id = votes.election_id \n" +
                        " where elections.id = :electionId \n" +
                        " group by candidate_name,candidate_id), \n" +
                        "results as (select region as region_new, count(votes.id) \n" +
                        "as votes_count , candidate_name , new_candidate_id \n" +
                        "from citizens \n" +
                        "join votes on citizens.id = votes.citizen_id \n" +
                        "join results_one on votes.candidate_id = results_one.new_candidate_id \n" +
                        " group by candidate_name, region_new,new_candidate_id) \n" +
                        "SELECT region_new,  \n" +
                        " max(votes_count) as amount_of_votes, max(candidate_name) as candidate_name , \n" +
                        "      sum(votes_count) as all_votes \n" +
                        " FROM results GROUP BY region_new \n" +
                        " order by all_votes desc";

                        Query query = em.createNativeQuery(queryString);
        query.setParameter("electionId", electionId);
        List<Object[]> resultList = query.getResultList();
        List<CandidateRegion> result = new ArrayList<>();
        resultList.forEach(object -> {
            CandidateRegion candidateRegion = new CandidateRegion();
            candidateRegion.setRegion(String.valueOf(object[0].toString()));
            candidateRegion.setAmountOfVotes(Integer.valueOf(object[1].toString()));
            candidateRegion.setName(String.valueOf(object[2].toString()));
            candidateRegion.setAllVotes(Integer.valueOf(object[3].toString()));

            result.add(candidateRegion);
        });
        return result;
    }

    @Override
    public List<CandidateTop> getNTopResultsInMRegions(Long electionId, int regionAmount, int positionAmount)
    {
        String queryString ="\n" +
                "with all_votes as (select count(votes.id) as general_count, elections.id as election from votes\n" +
                "join elections on elections.id = votes.election_id group by election),\t\t  \n" +
                "results_one as (select first_name || ' ' || last_name || ' ' ||   \n" +
                "fathers_name as candidate_name, candidate_id as  new_candidate_id from candidates \n" +
                "join citizens on citizens.id = candidates.citizen_id\n" +
                "join votes on candidates.id = votes.candidate_id\n" +
                "join elections on elections.id = votes.election_id\n" +
                "join all_votes on all_votes.election = elections.id\n" +
                "where elections.id = :electionId and candidates.id in\n" +
                "(select candidates.id from candidates\n" +
                "join citizens on citizens.id = candidates.citizen_id\n" +
                "join votes on votes.candidate_id = candidates.id\n" +
                "join elections on elections.id = votes.election_id\n" +
                "join all_votes on all_votes.election = elections.id\n" +
                "where elections.id = :electionId group by candidates.id limit :positionAmount)\n" +
                "group by candidate_name,candidate_id),\n" +
                "results as (select region as region_new, count(votes.id) \n" +
                "as votes_count , candidate_name , new_candidate_id from citizens  \n" +
                "join votes on citizens.id = votes.citizen_id   \n" +
                "join results_one on votes.candidate_id = results_one.new_candidate_id  \n" +
                "where citizens.region in ( select region from citizens\n" +
                "join votes on citizens.id = votes.citizen_id \n" +
                "join elections on elections.id = votes.election_id\n" +
                " where elections.id = :electionId group by region limit :regionAmount)\n" +
                "group by candidate_name, region_new,new_candidate_id)\n" +
                "select candidate_name,votes_count, region_new  from results\n" +
                "order by region_new";
        Query query = em.createNativeQuery(queryString);
        query.setParameter("electionId", electionId);
        query.setParameter("regionAmount", regionAmount);
        query.setParameter("positionAmount", positionAmount);

        List<Object[]> resultList = query.getResultList();
        List<CandidateTop> result = new ArrayList<>();
        resultList.forEach(object -> {
            CandidateTop candidateResult = new CandidateTop();
            candidateResult.setName(object[0].toString());
            candidateResult.setVotesCount(Integer.valueOf(object[1].toString()));
            candidateResult.setRegion(String.valueOf(object[2].toString()));
            result.add(candidateResult);
        });
        return result;

    }

    @Override
    public  List<CandidateAvg> getVotersAvgAge(Long electionId)
    {
        String queryString ="\n" +
                "with  needed as (select   candidate_id,  \n" +
                "  avg(EXTRACT(year from current_timestamp) - EXTRACT(year from date_of_birth)) as avg_age from votes\n" +
                " join  citizens on citizens.id = votes.citizen_id\n" +
                "where votes.election_id = :electionId \n" +
                "    group by  candidate_id) select first_name \n" +
                "||' ' ||last_name  as candidate_name , avg_age \n" +
                "from candidates\n" +
                " join citizens on citizens.id = candidates.citizen_id \n" +
                "join needed on needed.candidate_id = candidates.id  \n" +
                "group by  candidate_name, avg_age;";
        Query query = em.createNativeQuery(queryString);
        query.setParameter("electionId", electionId);
        List<Object[]> resultList = query.getResultList();
        List<CandidateAvg> result = new ArrayList<>();
        resultList.forEach(object -> {
            CandidateAvg candidateAvg = new CandidateAvg();
            candidateAvg.setCandidateName(String.valueOf(object[0]));
            candidateAvg.setAvgAge(String.valueOf(object[1]));
            result.add(candidateAvg);
        });
        return result;
    }
    @Override
    public List<CandidateCitizen> getCitizenAndTheCandidateHeVotedFor(Long electionId)
    {
        String queryString = " \n" +
                "with\n" +
                " all_votes as (select count(votes.id) as general_count, candidates.id as candidate from votes\n" +
                "   join candidates on candidates.id = votes.candidate_id\n" +
                "where votes.election_id = :electionId\n" +
                "          group by candidate),\n" +
                "\t\t  \n" +
                "    results_one as (select first_name || ' ' || last_name || ' ' ||   \n" +
                "\tfathers_name as candidate_name, candidate_id as  new_candidate_id    \n" +
                "from candidates join citizens on citizens.id = candidates.citizen_id\n" +
                "\t\t\t\t\tjoin votes on candidates.id = votes.candidate_id\n" +
                "\t\t\t\t\tjoin elections on elections.id = votes.election_id\n" +
                "\t\t\t\t\tgroup by candidate_name,candidate_id),\n" +
                "\t\t\t\t\t\n" +
                "\tresults as (select region as region_new, count(votes.id) \n" +
                "\t\t\t\t\t\t\t\tas votes_count , candidate_name , new_candidate_id    \n" +
                "\t\t\t\t\t\t\t\tfrom citizens  \n" +
                "\t\t\t\t\t\t\t\tjoin votes on citizens.id = votes.citizen_id   \n" +
                "\t\t\t\t\t\t\t\tjoin results_one on votes.candidate_id = results_one.new_candidate_id  \n" +
                "\t\t\t\t\t\t\t\tgroup by candidate_name, region_new,new_candidate_id),  \n" +
                " \n" +
                "\n" +
                "region_candidate as( select\n" +
                "region_new,\n" +
                "max(votes_count) as amount_of_votes, \n" +
                "max(candidate_name) as candidate_name ,\n" +
                "new_candidate_id,\n" +
                "sum(votes_count) as all_votes\n" +
                "FROM results GROUP BY region_new,new_candidate_id\n" +
                "order by all_votes desc)\n" +
                "\n" +
                "select first_name || ' ' || last_name \n" +
                "as citizen_name, region_new, candidate_name\n" +
                "from citizens\n" +
                "join votes on citizens.id = votes.citizen_id\n" +
                "join region_candidate on \n" +
                "region_candidate.new_candidate_id = votes.candidate_id\n" +
                "GROUP BY citizen_name,region_new,candidate_name\n" +
                ";\n";

        Query query = em.createNativeQuery(queryString);
        query.setParameter("electionId", electionId);
        List<Object[]> resultList = query.getResultList();
        List<CandidateCitizen> result = new ArrayList<>();
        resultList.forEach(object -> {
            CandidateCitizen candidateCitizen = new CandidateCitizen();
            candidateCitizen.setCitizenName(String.valueOf(object[0].toString()));
            candidateCitizen.setRegion(String.valueOf(object[1].toString()));
            candidateCitizen.setCandidateName(String.valueOf(object[2].toString()));

            result.add(candidateCitizen);
        });
        return result;
    }


}
