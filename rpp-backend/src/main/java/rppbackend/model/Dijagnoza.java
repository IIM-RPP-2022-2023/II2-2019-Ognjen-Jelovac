package rppbackend.model;
 
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Dijagnoza
 *
 */

@Entity

@Table(name = "Dijagnoza", schema = "public")
@NamedQuery(name="Dijagnoza.findAll", query="SELECT d FROM Dijagnoza d")

public class Dijagnoza implements Serializable {

	@Id
	@SequenceGenerator(name="DIJAGNOZA_ID_GENERATOR", sequenceName="DIJAGNOZA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIJAGNOZA_ID_GENERATOR")
	private Integer id;
	private String naziv;
	private String opis;
	private String oznaka;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="dijagnoza")
	@JsonIgnore
	private List<Pacijent> pacijent;

	public Dijagnoza() {
		super();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}   

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getOznaka() {
		return this.oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	
	
   
}
