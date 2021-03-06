package fr.epsi.classement;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/classement")
public class ClassementServlet extends HttpServlet {
	
	@EJB
	IClassementService classementService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("buzz")) {
			req.setAttribute("top", classementService.getTop3IdeesPlusDeVotes());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/classement/buzz.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("brains")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/classement/brains.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("tops")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/classement/tops.jsp").forward(req, resp);			
		} 
	}

}