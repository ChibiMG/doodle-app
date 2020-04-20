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

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {

	private EntityManager manager;

	private DaoParticipant newParticipant;

	private String name;
	private String firstname;
	private String email;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		name = request.getParameter("name");
		firstname = request.getParameter("firstname");
		email = request.getParameter("email");

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
				"</body></html>");

		try {
			newParticipant = new DaoParticipant();
			newParticipant.createParticipant(new Participant(name, firstname, email));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
