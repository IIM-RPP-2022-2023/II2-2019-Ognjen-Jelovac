package rppbackend.model; 

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Bolnica
 *
 */
@Entity

@Table(name = "Bolnica", schema = "public")
@NamedQuery(name="Bolnica.findAll", query="SELECT b FROM Bolnica b")

public class Bolnica implements Serializable {

	@Id
	@SequenceGenerator(name="BOLNICA_ID_GENERATOR", sequenceName="BOLNICA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOLNICA_ID_GENERATOR")
	private Integer id;
	private String naziv;
	private String adresa;
	private BigDecimal budzet;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="bolnica") 
	@JsonIgnore
	private List<Odeljenje> odeljenje;

	public Bolnica() {
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

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public BigDecimal getBudzet() {
		return this.budzet;
	}

	public void setBudzet(BigDecimal budzet) {
		this.budzet = budzet;
	}
   
}
