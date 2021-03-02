package it.cybsec.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="skill")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "tipologia")
	private String tipologia;
	
	@Column(name = "valutazione")
	private int valutazione;
	
	@Column(name = "certificati")
	private String certificati;


	@JsonIgnoreProperties("skill")
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "applicare", 
        joinColumns = { @JoinColumn(name = "id_skill") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_esami") }
    )
    private List<Esami> esami;

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

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getCertificati() {
		return certificati;
	}

	public void setCertificati(String certificati) {
		this.certificati = certificati;
	}


	public List<Esami> getEsami() {
		return this.esami;
	}

	public void setEsami(List<Esami> esami) {
		this.esami = esami;
	}


}
