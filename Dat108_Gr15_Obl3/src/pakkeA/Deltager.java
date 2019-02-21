package pakkeA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema="public", name="deltager")
public class Deltager {
	
	@Id
	private String mobilnr;
	
	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;
	
	public Deltager() {
	}
	
	public Deltager(String fornavn, String etternavn, String mobilnr, String passord, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnr = mobilnr;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn; 
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}
	
	public boolean erMann() {
		return kjonn.equals("m") || kjonn.equalsIgnoreCase("M");
	}
	public boolean erKvinne() {
		return kjonn.equals("k") || kjonn.equalsIgnoreCase("K");
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	
	
}
