package pakkeA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeltagerlisteServlet")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltagerlisteEAO eao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesjon = request.getSession(false);

	        if (sesjon == null || sesjon.getAttribute("username") == null) { //fjern utropsteikn her!!!
	            response.sendRedirect("loginnServlet?requiresLogin");
	        } else {
	        	List<Deltager> deltagerliste = eao.hentDeltagere();
//	        	List<Deltager> listeKopi = new ArrayList();
//	        	for(Deltager d : deltagerliste) {
//	        		listeKopi.add(d);
//	        	}
	        	Deltager paaloggetDeltager = (Deltager) sesjon.getAttribute("aktivbruker");
//	        	System.out.println("aktivbruker-attribute: " + paaloggetDeltager.getEtternavn() + " "+paaloggetDeltager.getFornavn());
//	        	int indeks = deltagerliste.indexOf(paaloggetDeltager); //kanskje ikkje deltager er blitt lagt til i databasen?
//	        	Deltager aktiv = deltagerliste.get(indeks);
//	        	System.out.println("aktiv deltager: " + aktiv.getFornavn() + " " + aktiv.getEtternavn());
//	        	deltagerliste.remove(indeks);
//	        	for(Deltager e : listeKopi) {
//	        		if(e.getMobilnr().matches(paaloggetDeltager.getMobilnr())) {
//	        			listeKopi.remove(e);
//	        		}
//	        	}
	        	sesjon.setAttribute("paalogget", paaloggetDeltager); //den som er pålogget
	        	sesjon.setAttribute("deltagerliste", deltagerliste); // listeKopi ||||| alle som er påmeldt unntatt den som er pålogget
	            request.getRequestDispatcher("WEB-INF/deltagerliste.jsp")
	            		.forward(request, response);
	        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
