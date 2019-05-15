package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> findAll() {
        List<Candidate> candidates = candidateService.findAll();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
        Candidate createdCandidate = candidateService.createCandidate(candidate);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> update(@RequestBody Candidate candidate) {
        return new ResponseEntity<>(candidateService.update(candidate),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable Long id) {
        return new ResponseEntity<>(candidateService.findById(id),
                HttpStatus.OK);
    }
}
