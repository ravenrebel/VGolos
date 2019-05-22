package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.dto.*;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.dto.CandidateAvg;
import com.vgolos.VGolos.dto.CandidateRegion;
import com.vgolos.VGolos.dto.CandidateResult;
import com.vgolos.VGolos.dto.CandidateTop;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.repository.CitizenRepository;
import com.vgolos.VGolos.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ResultController {
    private ResultRepository resultRepository;
    private CitizenRepository citizenRepository;

    @Autowired
    public ResultController(ResultRepository resultRepository,
                            CitizenRepository citizenRepository) {
        this.resultRepository = resultRepository;
        this.citizenRepository = citizenRepository;
    }

    @GetMapping("elections/winners/{electionId}/{minPercentage}")
    ResponseEntity<List<CandidateResult>> getResultsByElectionId(
            @PathVariable Long electionId, @PathVariable int minPercentage) {
        return new ResponseEntity<>(resultRepository
                .getResultsByElectionIdAndMinPercentage(electionId, minPercentage),
                HttpStatus.OK);
    }

    @GetMapping("elections/regionAndItsWinner/{electionId}")
    ResponseEntity<List<CandidateRegion>> getWinnerResultsByElectionId(
            @PathVariable Long electionId) {
        return new ResponseEntity<>(resultRepository
                .getWinnersInRegions(electionId),
                HttpStatus.OK);
    }

    @GetMapping("elections/topResults/{electionId}/{regionAmount}/{positionAmount}")
    ResponseEntity<List<CandidateTop>> getTopResultsByElectionId(
            @PathVariable Long electionId, @PathVariable int regionAmount, @PathVariable int positionAmount) {
        return new ResponseEntity<>(resultRepository
                .getNTopResultsInMRegions(electionId, regionAmount, positionAmount),
                HttpStatus.OK);
    }

    @GetMapping("elections/averageAge/{electionId}")
    ResponseEntity<List<CandidateAvg>>
    getAvgAgeResultsByElectionId(@PathVariable Long electionId) {
        return new ResponseEntity<>(resultRepository
                .getVotersAvgAge(electionId),
                HttpStatus.OK);
    }
    @GetMapping("elections/citizensAndCandidates/{electionId}")
    ResponseEntity<List<CandidateCitizen>>
    getResultsByElectionIdVotedForWinners(@PathVariable Long electionId) {
        return new ResponseEntity<>(resultRepository
                .getCitizenAndTheCandidateHeVotedForWinners(electionId),
                HttpStatus.OK);
    }


    @GetMapping("citizens/vote/{electionId}")
    ResponseEntity<List<Citizen>> getCitizensVotedInElectionById(@PathVariable Long electionId) {
        return new ResponseEntity<>(citizenRepository.findByVoteInElection(electionId), HttpStatus.OK);
    }
}
