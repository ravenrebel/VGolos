package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/citizens")
public class CitizenController {
    private CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Citizen>> findAll() {
        List<Citizen> citizens = citizenService.findAll();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Citizen> findByLogin(@PathVariable String login) {
        return new ResponseEntity<>(citizenService.findByLogin(login),
                HttpStatus.OK);
    }

    @GetMapping("/idn/{idn}")
    public ResponseEntity<Citizen> findByIdn(@PathVariable String idn) {
        return new ResponseEntity<>(citizenService.findByIdn(idn),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Citizen> create(@RequestBody Citizen citizen) {
        Citizen createdCitizen = citizenService.createCitizen(citizen);
        return new ResponseEntity<>(createdCitizen, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Citizen> update(@RequestBody Citizen citizen) {
        return new ResponseEntity<>(citizenService.update(citizen),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable Long id) {
        citizenService.deleteById(id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Citizen> findById(@PathVariable Long id) {
        return new ResponseEntity<>(citizenService.findById(id),
                HttpStatus.OK);
    }

    @GetMapping("/getAgeInDays/{id}")
    public ResponseEntity<Long> getAgeInDays(@PathVariable Long id) {
        return new ResponseEntity<>(citizenService.getAgeInDays(id),
                HttpStatus.OK);
    }

    @GetMapping("/getAge/{id}")
    public ResponseEntity<Long> getAge(@PathVariable Long id) {
        return new ResponseEntity<>(citizenService.getAge(id),
                HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Citizen>> search(String name) {
        List<Citizen> citizens = citizenService.search(name);
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }

    @GetMapping("/isAdult/{id}")
    public ResponseEntity<Boolean> isAdult(@PathVariable Long id) {
        return new ResponseEntity<>(citizenService.isAdult(id),
                HttpStatus.OK);
    }
}
