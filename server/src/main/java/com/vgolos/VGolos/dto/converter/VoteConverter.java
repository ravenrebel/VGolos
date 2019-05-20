package com.vgolos.VGolos.dto.converter;

import com.vgolos.VGolos.dto.ElectionDTO;
import com.vgolos.VGolos.dto.VoteDTO;
import com.vgolos.VGolos.dto.CandidateDTO;
import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.repository.CitizenRepository;
import com.vgolos.VGolos.repository.CandidateRepository;
import com.vgolos.VGolos.dto.converter.CandidateConverter;
import com.vgolos.VGolos.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class VoteConverter implements Converter<Vote, VoteDTO> {

    private CitizenRepository citizenRepository;
    private CandidateRepository candidateRepository;
    private ElectionRepository electionRepository;

    @Autowired
    public VoteConverter(CitizenRepository citizenRepository, CandidateRepository candidateRepository, CandidateConverter candidateConverter, ElectionRepository electionRepository) {
        this.citizenRepository = citizenRepository;
        this.candidateRepository = candidateRepository;
        this.candidateConverter = candidateConverter;
        this.electionRepository = electionRepository;
    }

    private CandidateConverter candidateConverter;

    @Override
    public VoteDTO convertToDTO(Vote vote) {
        VoteDTO voteDTO = new VoteDTO();
        voteDTO.setId(vote.getId());
        voteDTO.setCitizen(vote.getCitizen());
        voteDTO.setCandidate(candidateConverter.convertToDTO(vote.getCandidate()));
        voteDTO.setElectionId(vote.getElection().getId());
        return voteDTO;
    }

    @Override
    public Vote convertToEntity(VoteDTO voteDTO) {

        Vote vote = new Vote();
        vote.setId(voteDTO.getId());
        vote.setCitizen(citizenRepository.findById(voteDTO.getCitizen().getId()).get());
        vote.setCandidate(candidateRepository.findById(voteDTO.getCandidate().getId()).get());
        vote.setElection(electionRepository.findById(voteDTO.getElectionId()).get());
        return vote;
    }
}