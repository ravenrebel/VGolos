package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.dto.CandidateResult;
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
            candidateResult.setName((String)object[0]);
            candidateResult.setVotesCount((int)object[1]);
            candidateResult.setPercents((float)object[2]);
            result.add(candidateResult);
        });
        return result;
    }
}
