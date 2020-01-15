package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="mytest",
urlPatterns={"/myurl"})
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		PrintWriter p = new PrintWriter(resp.getOutputStream());
		p.print("Hello world SIR");
		p.flush();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   String name = req.getParameter("name");
		   String firstname = req.getParameter("firstname");
		   String age = req.getParameter("age");
		   
		super.doPost(req, resp);
	}	
}
