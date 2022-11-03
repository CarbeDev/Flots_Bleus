package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Resultat;
import com.simplon.course_voilier.model.key.ResultatKey;

@Repository
public interface ResultatRepo extends CrudRepository<Resultat, ResultatKey> {
    Iterable<Resultat> findByIdEpreuve(int idEpreuve);
}