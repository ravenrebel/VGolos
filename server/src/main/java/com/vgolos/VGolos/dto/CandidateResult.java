package com.vgolos.VGolos.dto;

public class CandidateResult {
    private String name;
    private int votesCount;
    private float percents;
    private int allVotes;
    private int amountOfVotes;
    private String region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
    }

    public float getPercents() {
        return percents;
    }

    public void setPercents(float percents) {
        this.percents = percents;
    }

    public void setAllVotes(Integer allVotes) {
        this.allVotes = allVotes;
    }

    public Integer getAllVotes() {
        return allVotes;
    }

    public void setAmountOfVotes(Integer amountOfVotes) {
        this.amountOfVotes = amountOfVotes;
    }

    public Integer getAmountOfVotes() {
        return amountOfVotes;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
