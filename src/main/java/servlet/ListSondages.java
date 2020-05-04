package servlet;

import dao.DaoReunion;
import dao.DaoSondage;
import jpa.Reunion;
import jpa.Sondage;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="listsondages",
        urlPatterns={"/ListSondages"})
public class ListSondages extends HttpServlet {

    private DaoSondage listSondages;

    private List<Sondage> sondages;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        listSondages = new DaoSondage();
        sondages = new ArrayList<Sondage>();

        try {
            sondages = listSondages.getAll();
               } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html>\n<body>\n" +
                "<h1>Liste des sondages disponibles : </h1>\n" +
                "<table border : 1px>");
        for (Sondage sondage : sondages){
            out.println("<tr><td>"+ sondage.getReunion().getIntitule() +
                    "</td><td>" + sondage.getReunion().getResume() +
                    "</td><td><a href ='/ParticiperSondage?id=" + sondage.getId() + "' >Participer</a>"+
                    "</td><td><a href ='/ReponsesSondage?id=" + sondage.getId() + "' >Reponses</a>"+ "</td></tr>");
        }
        out.println("</table>" +
                "<input type='button' name='Creer un sondage' value='Creer un sondage' onclick=\"self.location.href='addSondage.html'\" onclick>" +
                "</body></html>");
    }
}
