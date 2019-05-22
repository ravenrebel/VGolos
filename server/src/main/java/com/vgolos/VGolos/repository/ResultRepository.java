package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.dto.*;

import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository {

    /*@Query(
            value = "with all_votes as (select count(votes.id) as general_count, elections.id as election from votes\n" +
                    "   join elections on elections.id = votes.election_id\n" +
                    "           where election_id = :electionId\n" +
                    "          group by election),\n" +
                    "results as (select first_name || ' ' || last_name || ' ' || fathers_name as candidate_name, count(votes.id) as votes_count, \n" +
                    "      cast(count(votes.id) as float)*100/general_count as percents from candidates\n" +
                    "join citizens on citizens.id = candidates.citizen_id\n" +
                    "join votes on votes.candidate_id = candidates.id\n" +
                    "join elections on elections.id = votes.election_id\n" +
                    "join all_votes on all_votes.election = elections.id\n" +
                    "group by candidate_name, general_count)\n" +
                    "select candidate_name, votes_count, percents from results\n" +
                    "where percents >= :minPercentage\n " +
                    "order by percents desc;",
            nativeQuery = true
    )*/
    List<CandidateResult> getResultsByElectionIdAndMinPercentage(Long electionId, int minPercentage);
    List<CandidateRegion> getWinnersInRegions(Long electionId);
    List<CandidateTop> getNTopResultsInMRegions(Long electionId, int regionAmount, int positionAmount);
    List<CandidateAvg> getVotersAvgAge(Long electionId);
    List<CandidateCitizen> getCitizenAndTheCandidateHeVotedForWinners(Long electionId);




}
