package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByLogin(String login);
    List<Citizen> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    List<Citizen> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("select v.citizen from Vote v join Election e on v.election=e where e.id=:electionId")
    List<Citizen> findByVoteInElection(Long electionId);
}