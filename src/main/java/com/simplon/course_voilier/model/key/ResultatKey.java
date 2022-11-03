package com.simplon.course_voilier.model.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.simplon.course_voilier.model.Epreuve;
import com.simplon.course_voilier.model.Voilier;

import lombok.Data;

@Data
@Embeddable
public class ResultatKey implements Serializable{

	@Column(name="id_voilier")
	private int voilier;
	@Column(name="id_epreuve")
	private int epreuve;

	public ResultatKey(Voilier v, Epreuve e) {
		this.voilier = v.getId();
		this.epreuve = e.getId();
	}

	public ResultatKey(int v, int e) {
		this.voilier = v;
		this.epreuve = e;
	}

	public ResultatKey() {

	}

}
