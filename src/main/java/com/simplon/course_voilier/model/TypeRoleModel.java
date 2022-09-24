package com.simplon.course_voilier.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="type_role")
public class TypeRoleModel {
@Id
@Column(name="id_type_role")
private int id;
	
@Column(name="nom_type_role")
private String nom;

@OneToMany(mappedBy = "role")
private List<PersonneModel> personnes;
}
