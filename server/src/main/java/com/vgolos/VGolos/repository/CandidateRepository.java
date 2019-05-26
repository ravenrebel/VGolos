package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.entity.Candidate;
import com.vgolos.VGolos.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByElection(Election election);
}
