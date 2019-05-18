package com.vgolos.VGolos.controller;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/elections")
public class ElectionController {
    private ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }
    @GetMapping
    public ResponseEntity<List<Election>> findAll() {
        List<Election> elections = electionService.findAll();
        return new ResponseEntity<>(elections, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Election> create(@RequestBody Election election) {
        Election createdElection = electionService.createElection(election);
        return new ResponseEntity<>(createdElection, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        electionService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Election> findById(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.findById(id),
                HttpStatus.OK);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<Election>> search(String name) {
        List<Election> elections = electionService.search(name);
        return new ResponseEntity<>(elections, HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<Election> update(@RequestBody Election election) {
        return new ResponseEntity<>(electionService.update(election),
                HttpStatus.OK);
    }

    @GetMapping("/isFinished/{id}")
    public ResponseEntity<Boolean> isFinished(@PathVariable Long id) {
        return new ResponseEntity<>(electionService.isFinished(id),
                HttpStatus.OK);
    }
}

