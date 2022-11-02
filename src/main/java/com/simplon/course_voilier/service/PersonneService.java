package com.simplon.course_voilier.service;

import com.simplon.course_voilier.model.Personne;
import com.simplon.course_voilier.repository.PersonneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    @Autowired
    PersonneRepo pr;

    public Iterable<Personne> getPersonnes(){
        return pr.findAll();
    }

    public void addPersonne(Personne personne){
        pr.save(personne);
    }
}