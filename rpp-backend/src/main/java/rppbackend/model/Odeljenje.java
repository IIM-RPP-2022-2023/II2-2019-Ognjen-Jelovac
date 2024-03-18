package rppbackend.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Odeljenje
 *
 */

@Entity


@Table(name = "Odeljenje", schema = "public")
@NamedQuery(name="Odeljenje.findAll", query="SELECT o FROM Odeljenje o")


public class Odeljenje implements Serializable {

	@Id
	@SequenceGenerator(name="ODELJENJE_ID_GENERATOR", sequenceName="ODELJENJE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ODELJENJE_ID_GENERATOR")
	private Integer id;
	private String naziv;
	private String lokacija;
	
	@ManyToOne
	@JoinColumn(name="bolnica")
	private Bolnica bolnica;
	
	
private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="odeljenje" , cascade = {CascadeType.ALL}) 
	@JsonIgnore
	private List<Pacijent> pacijent;
	
	public Odeljenje() {
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


	public String getLokacija() {
		return this.lokacija;
	}


	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}


	public Bolnica getBolnica() {
		return this.bolnica;
	}


	public void setBolnica(Bolnica bolnica) {
		this.bolnica = bolnica;
	}

   
}
