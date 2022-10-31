package com.simplon.course_voilier.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplon.course_voilier.model.Equipage;
import com.simplon.course_voilier.model.EquipageModel;
@Repository
public interface EquipageRepository extends CrudRepository<Equipage,Integer>{

}
