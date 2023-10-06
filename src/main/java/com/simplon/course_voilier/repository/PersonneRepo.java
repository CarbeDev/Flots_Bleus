package com.simplon.course_voilier.repository;

import com.simplon.course_voilier.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends CrudRepository<Personne,Integer> {

}