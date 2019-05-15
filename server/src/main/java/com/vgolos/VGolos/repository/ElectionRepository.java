package com.vgolos.VGolos.repository;

import com.vgolos.VGolos.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {

    List<Election> findByNameContainingIgnoreCase(String Name);

}