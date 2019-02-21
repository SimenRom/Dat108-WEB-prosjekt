package pakkeA;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request);
		if(skjema.isAllInputGyldig()) {
			
			request.getSession().removeAttribute("skjema");
			Deltager nyPerson = skjema.lagPerson();
			nyPerson.setPassord(PassordUtil.krypterPassord(nyPerson.getPassord()));
			request.getSession().setAttribute("deltager", nyPerson);
			response.sendRedirect("BekreftingServlet");
		} else {
			skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("PaameldingServlet");
		}
	}
}
