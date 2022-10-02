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
@Table(name = "course")
public class Course implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_course")
	private int id;
	@Column(name="nom_course")
	private String nom;
	@Column(name="annee_course")
	private String annee;
	@OneToMany(mappedBy = "course")
	private List<Epreuve> epreuve;
	

	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		r.add(String.valueOf(this.annee));
		
		return r;
	}
	
	public static ArrayList<String> getAttributes() {
		return Model.getAttributes(Course.class);
	}
	
	public static ArrayList<String> getAttributesType(){
		return Model.getAttributesClass(Course.class);
	}

}
