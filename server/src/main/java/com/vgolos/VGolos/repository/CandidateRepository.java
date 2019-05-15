package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
