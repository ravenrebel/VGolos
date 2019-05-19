package com.vgolos.VGolos.dto;

public class CandidateTop {


        private String region;
        private String name;
        private int votesCount;


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

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegion() {
            return region;
        }

}
