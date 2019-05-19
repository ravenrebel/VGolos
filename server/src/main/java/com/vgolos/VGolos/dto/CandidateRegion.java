package com.vgolos.VGolos.dto;

public class CandidateRegion {
    private String region;
    private int amountOfVotes;
    private String name;
    private int allVotes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
