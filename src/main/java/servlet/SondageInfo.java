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
import javax.servlet.http.HttpSession;
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
    private HttpSession session;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        session = request.getSession();

        PrintWriter out = response.getWriter();
        intitule = request.getParameter("intitule");
        resume = request.getParameter("resume");
        datesString = request.getParameter("dates");

        createur = (Participant) session.getAttribute("participant");


        datesStringTab = datesString.split(";");
        for (String date: datesStringTab) {
            dates.add(new Date(date));
        }

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
        out.println("</ul>\n" + "</ul>\n" +
                "<input type='button' name='Participer au sondage' value='Participer au sondage' onclick=\"self.location.href='ParticipationSondage'\" onclick>" +
                "</body></html>");


        try {
            reunion = new Reunion (intitule, resume);
            newReunion = new DaoReunion();
            newSondage =  new DaoSondage();
            reunion.setSondage(newSondage.createSondage(new Sondage(newReunion.createReunion(reunion), dates, createur)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
