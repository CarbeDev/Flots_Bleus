package com.simplon.course_voilier.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Entreprise;

@Repository
public interface EntrepriseRepo extends CrudRepository<Entreprise, Integer>{


//@Modifying
//@Query("update Entrepise e set e.entreprise = :entreprise where e.id = :name")
//void updateEntreprise(@Param(value = "id") long id, @Param(value = "entreprise") String entrerpise);

}