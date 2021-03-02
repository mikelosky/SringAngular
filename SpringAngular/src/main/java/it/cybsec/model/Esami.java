package it.cybsec.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "esami")
public class Esami implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_esami")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "anno")
	private int anno;

	@Column(name = "crediti")
	private int crediti;

	@Column(name = "voto")
	private int voto;

	@JsonIgnoreProperties("esami")
	@ManyToMany(mappedBy = "esami", fetch = FetchType.EAGER)
	private List<Skill> skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	
}
