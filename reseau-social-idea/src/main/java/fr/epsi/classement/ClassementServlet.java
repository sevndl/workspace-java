package fr.epsi.classement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/classement")
public class ClassementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("buzz")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/buzz.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("brains")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/buzz.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("tops")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/buzz.jsp").forward(req, resp);			
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}