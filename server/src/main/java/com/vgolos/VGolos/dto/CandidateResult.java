package com.vgolos.VGolos.dto;

public class CandidateResult {
    private String name;
    private int votesCount;
    private float percents;

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
}
