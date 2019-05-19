package com.vgolos.VGolos.dto.converter;

import com.vgolos.VGolos.dto.ElectionDTO;
import com.vgolos.VGolos.dto.VoteDTO;
import com.vgolos.VGolos.dto.CandidateDTO;
import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.repository.VoteRepository;
import com.vgolos.VGolos.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ElectionConverter implements Converter<Election, ElectionDTO> {

    private VoteRepository voteRepository;
    private CandidateRepository candidateRepository;
    private CandidateConverter candidateConverter;

    @Autowired
    public ElectionConverter(VoteRepository voteRepository, CandidateRepository candidateRepository, CandidateConverter candidateConverter) {
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
        this.candidateConverter = candidateConverter;
    }

    @Override
    public ElectionDTO convertToDTO(Election election) {
        ElectionDTO electionDTO = new ElectionDTO();
        electionDTO.setBeginningOfVoting(election.getBeginningOfVoting());
        electionDTO.setEndOfVoting(election.getEndOfVoting());
        electionDTO.setId(election.getId());
        electionDTO.setName(election.getName());
        electionDTO.setTour(election.getTour());
        electionDTO.setYear(election.getYear());

        List<VoteDTO> votes = new LinkedList<>();
        for (Vote vote:
                election.getVotes()) {
            VoteDTO voteDTO = new VoteDTO();
            voteDTO.setId(vote.getId());
            voteDTO.setCitizen(vote.getCitizen());
            voteDTO.setElectionId(vote.getElection().getId());
            voteDTO.setCandidate(candidateConverter.convertToDTO(vote.getCandidate()));
            votes.add(voteDTO);
        }
        electionDTO.setVotes(votes);
        List<CandidateDTO> candidates = new LinkedList<>();
        for (Candidate candidate:
                election.getCandidates()) {
            CandidateDTO candidateDTO = new CandidateDTO();
            candidateDTO.setId(candidate.getId());
            candidateDTO.setCitizen(candidate.getCitizen());
            candidateDTO.setElectionId(candidate.getElection().getId());
            candidates.add(candidateDTO);
        }
        electionDTO.setCandidates(candidates);
        return electionDTO;
    }

    @Override
    public Election convertToEntity(ElectionDTO electionDTO) {
        Election election = new Election();
        List<Vote> votes = new LinkedList<>();
        for (VoteDTO voteDTO:
            electionDTO.getVotes()) {
            votes.add(voteRepository.findById(voteDTO.getId()).get());
        }
        List<Candidate> candidates = new LinkedList<>();
        for (CandidateDTO candidateDTO:
                electionDTO.getCandidates()) {
            candidates.add(candidateRepository.findById(candidateDTO.getId()).get());
        }
        election.setCandidates(candidates);
        election.setVotes(votes);
        election.setEndOfVoting(electionDTO.getEndOfVoting());
        election.setBeginningOfVoting(electionDTO.getBeginningOfVoting());
        election.setId(electionDTO.getId());
        election.setName(electionDTO.getName());
        election.setTour(electionDTO.getTour());
        election.setYear(electionDTO.getYear());
        return election;
    }
}
