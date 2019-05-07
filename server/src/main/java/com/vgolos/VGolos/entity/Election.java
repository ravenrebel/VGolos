package com.vgolos.VGolos.entity;

import java.util.Date;
import java.util.List;

public class Election
{
    private Long id;
    private String name;
    private int year;
    private int tour;
    private Date beginningOfVoting;
    private Date endOfVoting;
    private List<Candidate> candidates;
    private List<Vote> votes;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getTour()
    {
        return tour;
    }

    public void setTour(int tour)
    {
        this.tour = tour;
    }

    public Date getBeginningOfVoting()
    {
        return beginningOfVoting;
    }

    public void setBeginningOfVoting(Date beginningOfVoting)
    {
        this.beginningOfVoting = beginningOfVoting;
    }

    public Date getEndOfVoting()
    {
        return endOfVoting;
    }

    public void setEndOfVoting(Date endOfVoting)
    {
        this.endOfVoting = endOfVoting;
    }

    public List<Candidate> getCandidates()
    {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates)
    {
        this.candidates = candidates;
    }

    public List<Vote> getVotes()
    {
        return votes;
    }

    public void setVotes(List<Vote> votes)
    {
        this.votes = votes;
    }

}
