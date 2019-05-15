package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Election;
import com.vgolos.VGolos.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ElectionService {

    private ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public Election findById(Long id) {
        return electionRepository.findById(id).get();
    }

    public List<Election> search(String name) {
        String[] names = name.split("");
        List<Election> result;
        if (names.length > 1) {
            result = electionRepository.findByNameContainingIgnoreCase(names[1]);
        }
        else result = electionRepository.findByNameContainingIgnoreCase(names[0]);
        return result;
    }

    public Election createElection(Election election) {
        election.setId(-1L);
        Election createdElection = electionRepository.save(election);
        return createdElection;
    }



    public void deleteById(Long id) {
        electionRepository.deleteById(id);
    }
}