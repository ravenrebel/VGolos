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
        List<Election> elections = electionService.findAll();
        List<ElectionDTO> electionDTOs = new LinkedList<>();
        for (Election election:elections
        ) {
            electionDTOs.add(electionConverter
                    .convertToDTO(election));
        }
        return new ResponseEntity<>(electionDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ElectionDTO> create(@RequestBody ElectionDTO electionDTO) {
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
        Election election = electionService.update(electionConverter.convertToEntity(electionDTO));
        return new ResponseEntity<>(electionConverter
                .convertToDTO(election), HttpStatus.OK);
    }

    @GetMapping("/isFinished/{id}")
    public ResponseEntity<Boolean> isFinished(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.isFinished(id),
                HttpStatus.OK);
    }
}

