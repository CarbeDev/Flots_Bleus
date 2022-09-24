package com.simplon.course_voilier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, String>{
	Admin findByIdentifiant(String identifiant);
}
