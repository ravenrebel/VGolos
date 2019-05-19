package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.repository.VoteRepository;
import com.vgolos.VGolos.repository.ElectionRepository;
import com.vgolos.VGolos.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class VoteService {

    private VoteRepository voteRepository;
    private ElectionRepository electionRepository;
    private CitizenRepository citizenRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository, ElectionRepository electionRepository, CitizenRepository citizenRepository) {
        this.voteRepository = voteRepository;
        this.electionRepository = electionRepository;
        this.citizenRepository = citizenRepository;
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

    public boolean isExisting(Long electionId, Long citizenId){
        Election election = electionRepository.findById(electionId).get();
        Citizen citizen = citizenRepository.findById(citizenId).get();
        if (voteRepository.findByElectionAndCitizen(election, citizen) == null){
            return false;
        }
        else return true;
    }
}