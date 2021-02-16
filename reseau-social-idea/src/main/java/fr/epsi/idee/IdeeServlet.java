package fr.epsi.idee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idee")
public class IdeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/idees.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("ajouter")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterIdee.jsp").forward(req, resp);			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("ajouter")) {
			resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/home");
		}
	}

}
