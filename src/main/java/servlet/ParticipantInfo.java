package servlet;
import dao.DaoParticipant;
import jpa.Participant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="participantinfo",
urlPatterns={"/ParticipantInfo"})
public class ParticipantInfo extends HttpServlet {

	HttpSession session;

	private EntityManager manager;

	private DaoParticipant newParticipant;

	private String name;
	private String firstname;
	private String email;
	private Participant participant;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		name = request.getParameter("name");
		firstname = request.getParameter("firstname");
		email = request.getParameter("email");

		session = request.getSession();

		participant = new Participant(name, firstname, email);

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
			newParticipant = new DaoParticipant();
			newParticipant.createParticipant(participant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
