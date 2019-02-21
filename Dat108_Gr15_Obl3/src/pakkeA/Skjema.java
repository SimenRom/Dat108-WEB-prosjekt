package pakkeA;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	String fornavn;
	String fornavnFeilmelding;
	String etternavn;
	String etternavnFeilmelding;
	String telefon;
	String telefonFeilmelding;
	String passord;
	String passordFeilmelding;
	String passordKopi;
	String passordKopiFeilmelding;
	String kjonn;
	String kjonnFeilmelding;
	
	public Skjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.telefon = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordKopi = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}
	
	public boolean isFornavnGyldig() {
		return fornavn.length() >= 2 && fornavn.length() <= 20 && fornavn.matches("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\- ]{1,19}$");
	}
	
	public boolean isEtternavnGyldig() {
		return etternavn.length() >= 2 && etternavn.length() <= 20 && etternavn.matches("^[A-Z][A-Za-zÆØÅæøå\\-]{1,19}$");
	}
	
	public boolean isTelefonGyldig() {
		return telefon.matches("^[\\d]{8}$"); // && !deltagerlisteEAO.finnesTelefon(telefon);
	}
	public boolean isPassordGyldig() {
		return passord.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
	}
	public boolean isPassordKopiGyldig() {
		return passord.equals(passordKopi);
	}
	public boolean isKjonnGyldig() {
		return !(kjonn == null) && (kjonn.equals("mann") || kjonn.equals("kvinne"));
	}

	
	public Deltager lagPerson() {
		return new Deltager(fornavn, etternavn, telefon, passord, kjonn.substring(0, 1));
	}
	
	
	public boolean isAllInputGyldig() {
		return isFornavnGyldig() && isEtternavnGyldig() && isTelefonGyldig() && isPassordGyldig() && isPassordKopiGyldig() && isKjonnGyldig();
	}
	
	public void settOppFeilmeldinger() {
		if(!isFornavnGyldig()) {
			fornavn = ""; 
			fornavnFeilmelding = "Ugyldig navn";
		}
		if(!isEtternavnGyldig()) {
			etternavn="";
			etternavnFeilmelding = "Ugyldig etternavn";
		}
		if(!isTelefonGyldig()) {
			telefon="";
			telefonFeilmelding = "Ugyldig telefon";
		}
		if(!isPassordGyldig()) {
			passord="";
			passordKopi="";
			passordFeilmelding = "Ugyldig passord";
		}
		if(!isPassordKopiGyldig()) {
			passord="";
			passordKopi="";
			passordKopiFeilmelding = "Passord matcher ikkje";
		}
		if(!isKjonnGyldig()) {
			kjonnFeilmelding = "Du må velge kjønn";
		}
	}

	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getTelefonFeilmelding() {
		return telefonFeilmelding;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getPassordKopi() {
		return passordKopi;
	}

	public String getPassordKopiFeilmelding() {
		return passordKopiFeilmelding;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

	public String getKjonn() {
		return kjonn;
	}
	
	
}
