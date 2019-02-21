package pakkeA;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class DeltagerlisteEAO {
	
	@PersistenceContext(name = "studentPU") // referanse til persistenseunit i xml. linje 6 ca
	EntityManager em;
	
	public void leggTil(Deltager d) {
		em.persist(d);
	}
	
	public List<Deltager> hentDeltagere() {
		return em.createQuery("select d from Deltager d order by d.fornavn, d.etternavn", Deltager.class).getResultList();
//		return (List<Deltager>) em.find(Deltager.class, "12345678");
	}
	
	public Deltager finnDeltager(String username) {
		List<Deltager> liste = hentDeltagere();
		for(Deltager e : liste) {
			if(e.getMobilnr().equals(username)) {
//				System.out.println("eao fant " + e.getFornavn() + " " + e.getEtternavn());
				return e;
			}
		}
//		System.out.println("eao fant ingen deltager.");
		return null;
	}
}
