package rppbackend.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Pacijent
 *
 */
@Entity

@Table(name = "Pacijent", schema = "public")
@NamedQuery(name="Pacijent.findAll", query="SELECT p FROM Pacijent p")

public class Pacijent implements Serializable {

	@Id
	@SequenceGenerator(name="PACIJENT_ID_GENERATOR", sequenceName="PACIJENT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIJENT_ID_GENERATOR")
	private Integer id;
	private String ime;
	private String prezime;
	private boolean zdr_osiguranje;
	private Date datum_rodjenja;
	
	@ManyToOne
	@JoinColumn(name="odeljenje")
	private Odeljenje odeljenje;
	
	@ManyToOne
	@JoinColumn(name="dijagnoza")
	private Dijagnoza dijagnoza;
	
	private static final long serialVersionUID = 1L;

	public Pacijent() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public boolean isZdr_osiguranje() {
		return this.zdr_osiguranje;
	}

	public void setZdr_osiguranje(boolean zdr_osiguranje) {
		this.zdr_osiguranje = zdr_osiguranje;
	}

	public Date getDatum_rodjenja() {
		return this.datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public Odeljenje getOdeljenje() {
		return this.odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Dijagnoza getDijagnoza() {
		return this.dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
   
}
