package servlet;


import dao.DaoReunion;
import dao.DaoSondage;
import jpa.Participant;
import jpa.Reunion;
import jpa.Sondage;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="listsondage",
        urlPatterns={"/ListSondage"})
public class ListSondage {

    private EntityManager manager;

    private DaoSondage listSondages;

    private List<Sondage> sondages;

    private DaoReunion listReunions;

    private List<Reunion> reunions;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        listSondages = new DaoSondage();

        try {
            sondages = listSondages.getAll();
               } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html>\n<body>\n" +
                "<h1>Liste des sondages disponibles : </h1>\n" +
                "<table>");
        for (Sondage sondage : sondages){
            out.println("<tr><td>"+ sondage.getReunion().getIntitule() +"</td></tr>");
        }
        out.println("</table></body></html>");
    }
}
