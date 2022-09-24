package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.TypeVoilier;

@Repository
public interface TypeVoilierRepo extends CrudRepository<TypeVoilier, Integer>{

}
