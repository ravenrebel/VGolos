package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ElectionService {

    private ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public Election findById(Long id) {
        return electionRepository.findById(id).get();
    }

    public List<Election> search(String name) {
        return electionRepository.findByNameContainingIgnoreCase(name);
    }

    public Election createElection(Election election) {
        election.setId(-1L);
        Election createdElection = electionRepository.save(election);
        return createdElection;
    }

    public Election update(Election election) {
        Election existingElection = electionRepository.findById(election.getId()).get();
        Date currentDate = new Date();
        if (election.getBeginningOfVoting().before(currentDate)){ existingElection.setBeginningOfVoting(election.getBeginningOfVoting()); }
        if (election.getEndOfVoting().before(currentDate)){ existingElection.setEndOfVoting(election.getEndOfVoting()); }
        return electionRepository.save(existingElection);
    }

    public void deleteById(Long id) {
        electionRepository.deleteById(id);
    }

    public boolean isFinished(Long id){
        Election election = electionRepository.findById(id).get();
        Date currentDate = new Date();
        if (election.getEndOfVoting().before(currentDate) || election.getEndOfVoting().equals(currentDate)) return true;
        else return false;
    }

    public boolean isStarted(Long id){
        Election election = electionRepository.findById(id).get();
        Date currentDate = new Date();
        if (election.getBeginningOfVoting().before(currentDate) || election.getEndOfVoting().equals(currentDate)) return true;
        else return false;
    }
}