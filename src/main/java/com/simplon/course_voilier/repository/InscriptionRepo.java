package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Inscription;
import com.simplon.course_voilier.model.key.InscriptionKey;

@Repository
public interface InscriptionRepo extends CrudRepository<Inscription, InscriptionKey>{

	Iterable<Inscription> findByCourse_Id(int id);
}
