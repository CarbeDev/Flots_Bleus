package com.simplon.course_voilier.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="type_voilier")
public class TypeVoilier implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_type")
	private int id;
	@Column(name="nom_type")
	private String nom;

	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		
		return r;
	}
	
	public static ArrayList<String> getAttributes(){
		return Model.getAttributes(TypeVoilier.class);
	}
	
	public static ArrayList<String> getAttributesType() {
		return Model.getAttributesClass(TypeVoilier.class);
	}
}
