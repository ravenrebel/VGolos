package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.dto.CandidateDTO;
import com.vgolos.VGolos.dto.converter.ElectionConverter;
import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.service.ElectionService;
import com.vgolos.VGolos.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.vgolos.VGolos.dto.converter.CandidateConverter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService candidateService;
    private ElectionService electionService;
    private CandidateConverter candidateConverter;

    @Autowired
    public CandidateController(CandidateService candidateService, CandidateConverter candidateConverter,ElectionService electionService) {
        this.candidateService = candidateService;
        this.candidateConverter = candidateConverter;
        this.electionService = electionService;
    }

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CandidateDTO>> findAll() {
        List<Candidate> candidates = candidateService.findAll();
        return new ResponseEntity<>(candidateConverter
                .convertToDTO(candidates), HttpStatus.OK);
    }

    @PostMapping("/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CandidateDTO> create(@RequestBody CandidateDTO candidateDTO) {
        Candidate createdCandidate = candidateService.createCandidate(candidateConverter.convertToEntity(candidateDTO));
        return new ResponseEntity<>(candidateConverter
                .convertToDTO(createdCandidate), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CandidateDTO> update(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.update(candidateConverter.convertToEntity(candidateDTO));
        return new ResponseEntity<>(candidateConverter
                .convertToDTO(candidate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable Long id) {
        candidateService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(candidateConverter
                .convertToDTO(candidateService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/findByElectionId/{ElectionId}")
    public ResponseEntity<List<CandidateDTO>> findByElectionId(@PathVariable Long ElectionId) {
        List<Candidate> candidates = candidateService.findByElection(electionService.findById(ElectionId));
        return new ResponseEntity<>(candidateConverter
                .convertToDTO(candidates), HttpStatus.OK);
    }
}
