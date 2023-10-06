package com.simplon.course_voilier.model;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import com.simplon.course_voilier.model.key.ResultatKey;

import lombok.Data;

@Data
@Entity
@Table(name="resultat")
public class Resultat implements Model{

	@EmbeddedId
	@AttributeOverrides({
        @AttributeOverride(name = "id.voilier", column = @Column(name = "id_voilier")),
        @AttributeOverride(name = "id.epreuve", column = @Column(name = "id_epreuve")) })
	private ResultatKey id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_epreuve" ,referencedColumnName="id_epreuve",insertable = false, updatable = false)
	private Epreuve epreuve;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_voilier", referencedColumnName="id_voilier", insertable = false, updatable = false)
	private Voilier voilier;
	private Time temps;

	public Resultat(Epreuve e, Voilier v) {
		this.id = new ResultatKey(v,e);
	}

	public Resultat(int v, int e, Time t ) {
		this.id = new ResultatKey(v,e);
		this.temps = t;
	}

	public Resultat() {

	}

	public ArrayList<String> getAttributesValues() {
		ArrayList<String> r = new ArrayList<>();

		r.add(epreuve.getDepart());
		r.add(epreuve.getArrivee());
		r.add(voilier.getNom());
		r.add(temps.toString());

		return r;
	}


	public static ArrayList<String> getAttributes() {
		ArrayList<String> r = new ArrayList<>();

		r.add("Départ");
		r.add("Arrivée");
		r.add("Course");
		r.add("Temps");

		return r;
	}

}