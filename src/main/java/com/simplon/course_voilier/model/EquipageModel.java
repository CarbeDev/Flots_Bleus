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
@Table(name = "equipage")
public class EquipageModel {
@Id
@Column(name="id_equipage")
private int  id;

@Column(name="nom_equipage")
private String nom;
@OneToMany(mappedBy = "equipage")
private List<PersonneModel> personnes;





}
