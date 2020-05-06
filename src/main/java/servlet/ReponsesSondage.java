package servlet;

import dao.DaoReponse;
import dao.DaoSondage;
import jpa.Reponse;
import jpa.Sondage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="Reponsessondage",
        urlPatterns={"/ReponsesSondage"})
public class ReponsesSondage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        DaoReponse daoReponse = new DaoReponse();
        List<Reponse> reponses = new ArrayList<Reponse>();

        DaoSondage daoSondage = new DaoSondage();
        Sondage sondage = new Sondage();

        try {
            sondage = daoSondage.getSondageById(Long.valueOf(request.getParameter("id")));
            reponses = daoReponse.getReponseBySondageId(sondage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html>\n<body>\n" +
                "<h1>Nom : " + sondage.getReunion().getIntitule() + "</h1>\n" +
                "<p>Resume : " + sondage.getReunion().getResume() + "</p>\n" +
                "<p>Createur : " + sondage.getCreateur().getNom() + " " + sondage.getCreateur().getPrenom() +  "</p>\n" +
                "Reponses : " +
                "<table border : 1px>" +
                "<tr><td>Date</td><td>Participant</td><td>Email du participant</td></tr>");
        for (Reponse reponse : reponses){
            out.println("<tr><td>" + reponse.getDate().getDate() +
            "</td><td>" + reponse.getParticipant().getNom() + " " +
                    reponse.getParticipant().getPrenom() +
                    "</td><td>" + reponse.getParticipant().getEmail() + "</td></tr>");
        }
        out.println("</table>" +
                "<input type='button' name='Retour a la liste des sondages' value='Retour a la liste des sondages' onclick=\"self.location.href='ListSondages'\" onclick>" +
                "</body></html>");
    }

}
