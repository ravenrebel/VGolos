package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id).get();
    }

    public Candidate createCandidate(Candidate candidate) {
        candidate.setId(-1L);
        Candidate createdCandidate = candidateRepository.save(candidate);
        return createdCandidate;
    }

    public Candidate update(Candidate candidate) {
        Candidate existingCandidate = candidateRepository.findById(candidate.getId()).get();
        existingCandidate.getCitizen().setRole(candidate.getCitizen().getRole());
        return candidateRepository.save(existingCandidate);
    }

    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> findByElection(Election election) {
        return candidateRepository.findByElection(election);
    }
}