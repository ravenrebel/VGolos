package com.vgolos.VGolos.entity;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id",
            nullable = false)
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "id",
            nullable = false)
    private Citizen citizen;
    @ManyToOne
    @JoinColumn(name = "election_id", referencedColumnName = "id",
            nullable = false)
    private Election election;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

}
