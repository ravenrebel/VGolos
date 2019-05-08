package com.vgolos.VGolos.dto;

import java.util.Date;
import java.util.List;

public class ElectionDTO {
    private Long id;
    private String name;
    private int year;
    private int tour;
    private Date beginningOfVoting;
    private Date endOfVoting;
    private List<Long> candidatIds;
    private List<Long> voteIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public Date getBeginningOfVoting() {
        return beginningOfVoting;
    }

    public void setBeginningOfVoting(Date beginningOfVoting) {
        this.beginningOfVoting = beginningOfVoting;
    }

    public Date getEndOfVoting() {
        return endOfVoting;
    }

    public void setEndOfVoting(Date endOfVoting) {
        this.endOfVoting = endOfVoting;
    }

    public List<Long> getCandidatIds() {
        return candidatIds;
    }

    public void setCandidatIds(List<Long> candidatIds) {
        this.candidatIds = candidatIds;
    }

    public List<Long> getVoteIds() {
        return voteIds;
    }

    public void setVoteIds(List<Long> voteIds) {
        this.voteIds = voteIds;
    }
}
