package com.vgolos.VGolos.dto;

import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;

import javax.persistence.*;

public class VoteDTO {

    private Long id;
    private Citizen citizen;
    private CandidateDTO candidate;
    private Long ElectionId;

    public Long getId() {
        return id;
    }

    public Long getElectionId() {
        return ElectionId;
    }

    public void setElectionId(Long electionId) {
        ElectionId = electionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CandidateDTO getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDTO candidate) {
        this.candidate = candidate;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
