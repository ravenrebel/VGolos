package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/votes")
public class VoteController {
    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<Vote>> findAll() {
        List<Vote> votes = voteService.findAll();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vote> create(@RequestBody Vote vote) {
        Vote createdVote = voteService.createVote(vote);
        return new ResponseEntity<>(createdVote, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vote> update(@RequestBody Vote vote) {
        return new ResponseEntity<>(voteService.update(vote),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        voteService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Vote> findByLogin(@PathVariable Long id) {
        return new ResponseEntity<>(voteService.findById(id),
                HttpStatus.OK);
    }

}
