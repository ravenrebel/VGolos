package com.vgolos.VGolos.dto.converter;

import com.vgolos.VGolos.dto.ElectionDTO;
import com.vgolos.VGolos.dto.VoteDTO;
import com.vgolos.VGolos.dto.CandidateDTO;
import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.entity.Vote;
import com.vgolos.VGolos.repository.CitizenRepository;
import com.vgolos.VGolos.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CandidateConverter implements Converter<Candidate, CandidateDTO> {

    private CitizenRepository citizenRepository;
    private ElectionRepository electionRepository;

    @Autowired
    public CandidateConverter(CitizenRepository citizenRepository, ElectionRepository electionRepository) {
        this.citizenRepository = citizenRepository;
        this.electionRepository = electionRepository;
    }

    @Override
    public CandidateDTO convertToDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId(candidate.getId());
        candidateDTO.setCitizen(candidate.getCitizen());
        candidateDTO.setElectionId(candidate.getElection().getId());
        return candidateDTO;
    }

    @Override
    public Candidate convertToEntity(CandidateDTO candidateDTO) {

        Candidate candidate = new Candidate();
        candidate.setId(candidateDTO.getId());
        candidate.setCitizen(citizenRepository.findById(candidateDTO.getCitizen().getId()).get());
        candidate.setElection(electionRepository.findById(candidateDTO.getElectionId()).get());
        return candidate;
    }
}
