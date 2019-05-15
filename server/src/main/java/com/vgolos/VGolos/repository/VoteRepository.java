package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}