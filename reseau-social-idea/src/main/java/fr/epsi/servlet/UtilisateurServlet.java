package fr.epsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("inscription")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("connexion")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("inscription")) {
			resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/home");
		} else if (req.getParameter("action").equals("connexion")) {
			resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/home");
		}
	}

}
