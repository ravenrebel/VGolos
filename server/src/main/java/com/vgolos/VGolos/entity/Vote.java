package com.vgolos.VGolos.entity;

public class Vote
{
    private Long id;
    private Candidate candidate;
    private Citizen citizen;
    private Election election;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Candidate getCandidate()
    {
        return candidate;
    }

    public void setCandidate(Candidate candidate)
    {
        this.candidate = candidate;
    }

    public Citizen getCitizen()
    {
        return citizen;
    }

    public void setCitizen(Citizen citizen)
    {
        this.citizen = citizen;
    }

    public Election getElection()
    {
        return election;
    }

    public void setElection(Election election)
    {
        this.election = election;
    }

}
