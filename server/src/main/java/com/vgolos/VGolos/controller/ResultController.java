package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.dto.CandidateResult;
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

    @Autowired
    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping("elections/{electionId}/{minPercentage}")
    ResponseEntity<List<CandidateResult>> getResultsByElectionId(
            @PathVariable Long electionId, @PathVariable int minPercentage) {
        return new ResponseEntity<>(resultRepository
                .getResultsByElectionIdAndMinPercentage(electionId, minPercentage),
                HttpStatus.OK);
    }
}