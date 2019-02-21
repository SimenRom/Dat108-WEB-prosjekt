package pakkeA;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginnServlet")
public class loginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private DeltagerlisteEAO eao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Forespørselen din krever pålogging.";

		} else if (request.getParameter("invalidLogin") != null) {
			loginMessage = "Manglende eller ugyldig brukernavn";
		}
		request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("mobil");
		String password = request.getParameter("passord");
//		System.out.println("username: " + username + ", pass: " + password);
		if(username == "" || password == "" || !Validator.validLogin(eao, username, password)) { //username == null || 
			response.sendRedirect("loginnServlet?invalidLogin");
		} else {

            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
//            sesjon.setMaxInactiveInterval(10);
            sesjon.setAttribute("username", username);
            
            sesjon.setAttribute("aktivbruker", eao.finnDeltager(username));
            System.out.println("deltager funnet: " + eao.finnDeltager(username).getEtternavn());
            response.sendRedirect("DeltagerlisteServlet");
        }
	}

}
