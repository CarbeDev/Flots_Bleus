package com.simplon.course_voilier.model;

import java.util.ArrayList;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.simplon.course_voilier.model.key.InscriptionKey;

import lombok.Data;

@Data
@Entity
@Table(name="inscription")
public class Inscription implements Model{

	@EmbeddedId
	private InscriptionKey id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipage",referencedColumnName = "id_equipage",insertable = false, updatable = false)
	private Equipage equipage;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_voilier",referencedColumnName = "id_voilier",insertable = false, updatable = false)
	private Voilier voilier;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_course",referencedColumnName = "id_course",insertable = false, updatable = false)
	private Course course;
	private Boolean desistement;
	
	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();
		
		r.add(this.voilier.getNom());
		r.add(this.equipage.getNom());
		r.add(String.valueOf(this.desistement));
		
		return r;
	}
	
	public static ArrayList<String> getAttributes(){
		return Model.getAttributes(Inscription.class);
	}
	
	public static ArrayList<String> getAttributesType() {
		return Model.getAttributesClass(Inscription.class);
	}

	
}