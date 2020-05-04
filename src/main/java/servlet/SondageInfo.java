package servlet;

import dao.DaoSondage;
import jpa.*;

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
        out.println("</ul>\n" + "</ul>\n");

        Reunion reunion = new Reunion (intitule, resume);
        Sondage sondage = new Sondage();
        sondage.setReunion(reunion);
        sondage.setDates(dates);
        sondage.setCreateur(createur);

        try {
            DaoSondage newSondage =  new DaoSondage();
            newSondage.createSondage(sondage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println( "<input type='button' name='Participer au sondage' value='Participer au sondage' onclick=\"self.location.href='/ParticiperSondage?id=" + sondage.getId() + "'\" onclick>" +
                "</body></html>");
    }
}
