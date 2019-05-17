package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    public Vote findById(Long id) {
        return voteRepository.findById(id).get();
    }


    public Vote createVote(Vote vote) {
        vote.setId(-1L);
        Vote createdVote = voteRepository.save(vote);
        return createdVote;
    }

    public Vote update(Vote vote) {
        Vote existingVote = voteRepository.findById(vote.getId()).get();
        return voteRepository.save(existingVote);
    }

    public void deleteById(Long id) {
        voteRepository.deleteById(id);
    }
}