package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Entreprise;

@Repository
public interface EntrepriseRepo extends CrudRepository<Entreprise, Integer>{

}
