package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CitizenService {

    private CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public List<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    public Citizen findByLogin(String login) {
        return citizenRepository.findByLogin(login).get();
    }

    public Citizen findByIdn(String idn) {
        return citizenRepository.findByIdn(idn).get();
    }

    public Citizen findById(Long id) {
        return citizenRepository.findById(id).get();
    }

    public long getAgeInDays(Long id){
        Date currentDate = new Date();
        Long diffInMillies = Math.abs(currentDate.getTime() - citizenRepository.findById(id).get().getDateOfBirth().getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public long getAge(Long id){
        Date currentDate = new Date();
        Long diffInMillies = Math.abs(currentDate.getTime() - citizenRepository.findById(id).get().getDateOfBirth().getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
    }

    public List<Citizen> search(String name) {
       return citizenRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    public Citizen createCitizen(Citizen citizen) {
        citizen.setId(-1L);
        citizen.setLogin(citizen.getIdn());
        Citizen createdCitizen = citizenRepository.save(citizen);
        return createdCitizen;
    }

    public Citizen update(Citizen account) {
        Citizen citizen = citizenRepository.findById(account.getId()).get();
        citizen.setRole(account.getRole());
        citizen.setFirstName(account.getFirstName());
        citizen.setLastName(account.getLastName());
        citizen.setRegion(account.getRegion());
        return citizenRepository.save(citizen);
    }

    public void deleteById(Long id) {
        citizenRepository.deleteById(id);
    }

    public boolean isAdult(Long id){
        if (getAgeInDays(id) >= 6553){
            return true;
        }
        else return false;
    }
}