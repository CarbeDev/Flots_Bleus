package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Voilier;

@Repository
public interface VoilierRepo extends CrudRepository<Voilier, Integer>{

}
