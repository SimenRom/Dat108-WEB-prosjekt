package pakkeA;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;

@WebServlet("/BekreftingServlet")
public class BekreftingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerlisteEAO eao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null && sesjon.getAttribute("deltager") != null) {
			eao.leggTil((Deltager) sesjon.getAttribute("deltager"));
		}
		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null) {
			System.out.println("Noke feil! Har ingen sesjon frå paamelding.");
		}
//		sesjon = request.getSession(true);
		Deltager nn = ((Deltager) sesjon.getAttribute("deltager"));
		sesjon.setAttribute("username", nn.getMobilnr());

		sesjon.setAttribute("aktivbruker", eao.finnDeltager(nn.getMobilnr()));
		System.out.println("deltager funnet: " + eao.finnDeltager(nn.getMobilnr()).getEtternavn());
		response.sendRedirect("DeltagerlisteServlet");
	}

}
