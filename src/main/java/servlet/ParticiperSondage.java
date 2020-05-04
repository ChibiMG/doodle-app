package servlet;

import dao.DaoParticipant;
import dao.DaoSondage;
import jpa.Date;
import jpa.Participant;
import jpa.Sondage;

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

@WebServlet(name="Participersondage",
        urlPatterns={"/ParticiperSondage"})
public class ParticiperSondage extends HttpServlet {

    private HttpSession session;

    private DaoSondage sondage;

    private List<Date> dates;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        session = request.getSession();
        dates = new ArrayList<Date>();

        Participant participant = (Participant) session.getAttribute("participant");

        try {
            dates = sondage.getSondageById(Long.valueOf(request.getParameter("id"))).getDates();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<html>\n<body>\n" + "<h1>Choisir une date : </h1>\n" +
                "<form>");
        for (Date date : dates){
            out.println("<input type='radio' name='date' value='" + date.getDate() +
                    "'>" + date.getDate());
        }
        out.println("</form>" +
                "</body></html>");
    }
}
