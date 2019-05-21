package com.vgolos.VGolos.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "elections")
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column
    private int year;
    @Column(nullable = false)
    private int tour;
    @Column
    //@Temporal(TemporalType.TIME)
    private Date beginningOfVoting;
    @Column
    //@Temporal(TemporalType.TIME)
    private Date endOfVoting;
    @OneToMany(mappedBy = "election")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Candidate> candidates;
    @OneToMany(mappedBy = "election")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Vote> votes;

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

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

}
