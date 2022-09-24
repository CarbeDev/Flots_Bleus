package com.simplon.course_voilier.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Voilier")
public class Voilier implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_voilier")
	private int id;
	@Column(name="nom_voilier")
	private String nom;
	private int longueur;
	private int largeur;
	@Column(name="const_annee")
	private int anneeConstruction;
	@ManyToOne
	@JoinColumn(name = "id_type", referencedColumnName = "id_type")
	private TypeVoilier type;
	@OneToMany(mappedBy = "voilier")
	private List<Entreprise> entreprise;
	
	public String toString() {
		return String.valueOf(this.nom);
	}
	
	public static ArrayList<String> getAttributes(){
		return Model.getAttributes(Voilier.class);
	}
	
	public static ArrayList<String> getAttributesType() {
		return Model.getAttributesClass(Voilier.class);
	}
	
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(String.valueOf(this.id));
		r.add(this.nom);
		r.add(String.valueOf(this.longueur));
		r.add(String.valueOf(this.largeur));
		r.add(String.valueOf(this.anneeConstruction));
		r.add(this.type.getNom());
		
		return r;
	}
}
