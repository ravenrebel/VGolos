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
        String[] names = name.split("");
        List<Citizen> result;
        if (names.length > 1) {
            result = citizenRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(names[1], names[0]);
        }
        else result = citizenRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(names[0], names[0]);
        return result;
    }

    public Citizen createCitizen(Citizen citizen) {
        citizen.setId(-1L);
        Citizen createdCitizen = citizenRepository.save(citizen);
        return createdCitizen;
    }

    public Citizen update(Citizen account) {
        Citizen existingAccount = citizenRepository.findById(account.getId()).get();
        existingAccount.setRole(account.getRole());
        return citizenRepository.save(existingAccount);
    }

    public void deleteById(Long id) {
        citizenRepository.deleteById(id);
    }
}