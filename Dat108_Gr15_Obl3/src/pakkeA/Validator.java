package pakkeA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

public class Validator {

	public static boolean validLogin(DeltagerlisteEAO eao, String username, String password) {
//		DeltakerEAO eao = new DeltakerEAO();
//		eao.getList()
//		hente brukere som er påmeldt og sjekke om det stemmer med parameter
		List<Deltager> liste = eao.hentDeltagere();
//		eao.leggTil(new Deltager("Simen", "Romstad", "12345678", "aaaaaaaa", 'm'));
//		List<Deltager> liste = new ArrayList();
		if (liste != null) {
			for (Deltager e : liste) {
				if (e.getMobilnr().equals(username)) {
//					System.out.println("Fant " + e.getFornavn());
//					System.out.println(PassordUtil.sjekkPassord(password, e.getPassord()));
					return PassordUtil.sjekkPassord(password, e.getPassord());
				}
			}
		}
//		System.out.println("Fant ingen");
		return false;
	}

}
