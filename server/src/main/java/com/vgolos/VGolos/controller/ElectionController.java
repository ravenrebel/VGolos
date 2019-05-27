package com.vgolos.VGolos.controller;
import com.vgolos.VGolos.dto.ElectionDTO;
import com.vgolos.VGolos.dto.converter.ElectionConverter;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/elections")
public class ElectionController {
    private ElectionService electionService;

    private ElectionConverter electionConverter;

    @Autowired
    public ElectionController(ElectionService electionService, ElectionConverter electionConverter) {
        this.electionService = electionService;
        this.electionConverter = electionConverter;
    }

    @GetMapping
    public ResponseEntity<List<ElectionDTO>> findAll() {
        return new ResponseEntity<>(electionConverter.convertToDTO(electionService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ElectionDTO> create(@RequestBody ElectionDTO electionDTO) {
        electionDTO.setCandidates(new LinkedList<>());
        electionDTO.setVotes(new LinkedList<>());
        Election createdElection = electionService.createElection(electionConverter.convertToEntity(electionDTO));
        return new ResponseEntity<>(electionConverter
                .convertToDTO(createdElection), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        electionService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<ElectionDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(electionConverter
                .convertToDTO(electionService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ElectionDTO>> search(String name) {
        List<Election> elections = electionService.search(name);
        return new ResponseEntity<>(electionConverter
                .convertToDTO(elections), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ElectionDTO> update(@RequestBody ElectionDTO electionDTO) {
        ElectionDTO existingElection = electionConverter
                .convertToDTO(electionService.findById(electionDTO.getId()));
        electionDTO.setCandidates(existingElection.getCandidates());
        electionDTO.setVotes(existingElection.getVotes());
        Election election = electionService.update(electionConverter.convertToEntity(electionDTO));
        return new ResponseEntity<>(electionConverter
                .convertToDTO(election), HttpStatus.OK);
    }

    @GetMapping("/isFinished/{id}")
    public ResponseEntity<Boolean> isFinished(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.isFinished(id),
                HttpStatus.OK);
    }

    @GetMapping("/isStarted/{id}")
    public ResponseEntity<Boolean> isStarted(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.isStarted(id),
                HttpStatus.OK);
    }

    @GetMapping("/isActive/{id}")
    public ResponseEntity<Boolean> isActive(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.isActive(id),
                HttpStatus.OK);
    }

    @GetMapping("/started")
    public ResponseEntity<List<ElectionDTO>> findStarted() {
        return new ResponseEntity<>(electionConverter.convertToDTO(electionService.findStarted()), HttpStatus.OK);
    }

    @GetMapping("finished")
    public ResponseEntity<List<ElectionDTO>> findFinished() {
        return new ResponseEntity<>(electionConverter.convertToDTO(electionService.findFinished()), HttpStatus.OK);
    }

    @GetMapping("active")
    public ResponseEntity<List<ElectionDTO>> findActive() {
        return new ResponseEntity<>(electionConverter.convertToDTO(electionService.findActive()), HttpStatus.OK);
    }
}

