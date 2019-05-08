package com.vgolos.VGolos.entity;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
