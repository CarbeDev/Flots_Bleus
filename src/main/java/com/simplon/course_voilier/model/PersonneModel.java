package com.simplon.course_voilier.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="personne")
public class PersonneModel {
@Id
@Column(name="id_personne")
private int id;

@Column(name="nom_personne")
private String nom;
private String prenom;

@Column(name="date_de_naissance")
private Date dateNaissance; 
@ManyToOne
@JoinColumn(name="id_type_role",referencedColumnName = "id_type_role")
private TypeRoleModel role;

@ManyToOne
@JoinColumn(name="id_equipage",referencedColumnName = "id_equipage")
private EquipageModel equipage;


}
