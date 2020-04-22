package servlet;

import dao.DaoParticipant;
import dao.DaoReunion;
import dao.DaoSondage;
import jpa.Date;
import jpa.Participant;
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

@WebServlet(name="Sondageinfo",
        urlPatterns={"/SondageInfo"})
public class SondageInfo extends HttpServlet {

    private EntityManager manager;

    private DaoSondage newSondage;

    private DaoReunion newReunion;

    private Reunion reunion;
    private String intitule;
    private String resume;
    private String datesString;
    private String[] datesStringTab;
    private List<Date> dates = new ArrayList<Date>();

    private Participant createur;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        intitule = request.getParameter("intitule");
        resume = request.getParameter("resume");
        datesString = request.getParameter("dates");


        datesStringTab = datesString.split(";");
        for (String date: datesStringTab) {
            dates.add(new Date(date));
        }

        String essai = "['date1','date2','date3'];";

        out.println("<html>\n<body>\n" +
                "<h1>Recapitulatif des informations</h1>\n" +
                "<ul>\n" +
                " <li>Intitule : "
                + intitule + "\n" +
                " <li>Resume : "
                + resume + "\n" +
                " <li>dates : \n"+
                "<ul>");
        for (Date date : dates){
            out.println("<li> " + date.getDate() +"\n");
        }
        out.println("</ul>\n" + "</ul>\n" + "</body></html>");

        try {
            reunion = new Reunion (intitule, resume);
            newReunion = new DaoReunion();
            newSondage =  new DaoSondage();
            newSondage.createSondage(new Sondage(newReunion.createReunion(reunion), dates, new Participant("Mémé", "Lavieille", "mémé@lavieille.fr")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
