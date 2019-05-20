package com.vgolos.VGolos.dto;

import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Election;

import javax.persistence.*;

public class CandidateDTO {
    private Long id;
    private Citizen citizen;

    public Long getElectionId() {
        return electionId;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }

    private Long electionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
