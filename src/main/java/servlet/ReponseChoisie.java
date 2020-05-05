package servlet;

import jpa.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Reponsechoisie",
        urlPatterns={"/ReponseChoisie"})
public class ReponseChoisie extends HttpServlet {

    private  String dateChoisie;

    private Participant participant;
    private HttpSession session;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        session = request.getSession();

        PrintWriter out = response.getWriter();
        dateChoisie = request.getParameter("date");

        participant = (Participant) session.getAttribute("participant");

        out.println("<html>\n<body>\n" +
                "<h1>Recapitulatif du choix</h1>\n" +
                "<ul>\n" +
                " <li>Date choisie : "
                + dateChoisie + "\n" +
                "</ul>");

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println( "<input type='button' name='Liste des sondages' value='Liste des sondages' onclick=\"self.location.href='/ListSondages'\" onclick>" +
                "</body></html>");
    }

}
