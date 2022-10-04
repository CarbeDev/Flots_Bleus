package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Epreuve;

@Repository
public interface EpreuveRepo extends CrudRepository<Epreuve, Integer>{

	Iterable<Epreuve> findByCourse_Id(int idCourse);
}
