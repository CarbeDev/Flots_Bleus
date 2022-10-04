package com.simplon.course_voilier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="type_role")
public class TypeRole implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_type_role")
	private int id;
		
	@Column(name="nom_type_role")
	private String nom;

	@OneToMany(mappedBy = "role")
	private List<Personne> personnes;
	
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		
		return r;
	}
	
	public static ArrayList<String> getAttributes(){
		return Model.getAttributes(TypeRole.class);
	}
	
	public static ArrayList<String> getAttributesType() {
		return Model.getAttributesClass(TypeRole.class);
	}

}
