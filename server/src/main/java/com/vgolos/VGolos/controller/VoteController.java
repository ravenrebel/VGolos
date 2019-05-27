package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.dto.VoteDTO;
import com.vgolos.VGolos.dto.converter.VoteConverter;
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
    private VoteConverter voteConverter;

    @Autowired
    public VoteController(VoteService voteService, VoteConverter voteConverter) {
        this.voteService = voteService;
        this.voteConverter = voteConverter;
    }

    @GetMapping
    public ResponseEntity<List<VoteDTO>> findAll() {
        List<Vote> votes = voteService.findAll();
        return new ResponseEntity<>(voteConverter.convertToDTO(votes), HttpStatus.OK);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    public ResponseEntity<VoteDTO> create(@RequestBody VoteDTO voteDTO) {
        Vote createdVote = voteService.createVote(voteConverter.convertToEntity(voteDTO));
        return new ResponseEntity<>(voteConverter.convertToDTO(createdVote), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VoteDTO> update(@RequestBody VoteDTO voteDTO) {
        Vote vote = voteService.update(voteConverter.convertToEntity(voteDTO));
        return new ResponseEntity<>(voteConverter
                .convertToDTO(vote), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        voteService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<VoteDTO> findByLogin(@PathVariable Long id) {
        return new ResponseEntity<>(voteConverter.convertToDTO(voteService.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping("/isExisting/{electionId}/{citizenId}")
    public ResponseEntity<Boolean> isExisting(@PathVariable Long electionId, @PathVariable Long citizenId) {
        return new ResponseEntity<>((voteService.isExisting(electionId, citizenId)),
                HttpStatus.OK);
    }
}
