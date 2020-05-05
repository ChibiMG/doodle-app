package servlet;
import dao.DaoParticipant;
import jpa.Participant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="participantinfo",
urlPatterns={"/ParticipantInfo"})
public class ParticipantInfo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");

		HttpSession session = request.getSession();

		DaoParticipant daoParticipant = new DaoParticipant();

		Participant participant = new Participant(name, firstname, email);

		session.setAttribute("participant", participant);

		out.println("<html>\n<body>\n" +
				"<h1>Recapitulatif des informations</h1>\n" +
				"<ul>\n" +
				" <li>Nom: "
				+ name + "\n" +
				" <li>Prenom: "
				+ firstname + "\n" +
				" <li>Adresse e-mail: "
				+ email + "\n" +
				"</ul>\n" +
				"<input type='button' name='Creer un sondage' value='Creer un sondage' onclick=\"self.location.href='addSondage.html'\" onclick>" +
				"<input type='button' name='Participer a un sondage' value='Participer a un sondage' onclick=\"self.location.href='/ListSondages'\" onclick>" +
				"</body></html>");

		try {
			daoParticipant.createParticipant(participant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
