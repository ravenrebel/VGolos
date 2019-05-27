package com.vgolos.VGolos.dto;

public class CandidateAvg {
    private String candidateName;
    private String avgAge;



    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String name) {
        this.candidateName = name;
    }

    public String getAvgAge(){return avgAge;}

    public void setAvgAge(String avgAge) {
        this.avgAge = avgAge;
    }

}
