package servlet;

import dao.DaoDate;
import dao.DaoReponse;
import dao.DaoSondage;
import jpa.Date;
import jpa.Participant;
import jpa.Reponse;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Long dateChoisie = Long.valueOf(request.getParameter("date"));

        DaoDate daoDate = new DaoDate();
        DaoSondage daoSondage = new DaoSondage();
        DaoReponse daoReponse = new DaoReponse();

        Participant participant = (Participant) session.getAttribute("participant");

        Long numSondage = Long.valueOf(request.getParameter("id"));

        out.println("<html>\n<body>\n" +
                "<h1>Recapitulatif du choix pour le sondage : " + daoSondage.getSondageById(numSondage).getReunion().getIntitule() + "</h1>\n" +
                "<ul>\n" +
                " <li>Date choisie : " +  daoDate.getDateById(dateChoisie).getDate() + "\n" +
                "</ul>");

        Reponse reponse = new Reponse(participant, daoDate.getDateById(dateChoisie), daoSondage.getSondageById(numSondage));

        try {
            daoReponse.createReponse(reponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println( "<input type='button' name='Liste des sondages' value='Liste des sondages' onclick=\"self.location.href='/ListSondages'\" onclick>" +
                "</body></html>");
    }

}
