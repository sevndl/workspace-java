package fr.epsi.utilisateur;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

	@EJB
	private IUtilisateurService utilisateurService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("inscription")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription/inscription.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("connexion")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion/connexion.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("deconnexion")) {
			HttpSession session = req.getSession(true);
			session.invalidate();
			resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/home");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("inscription")) {
			String username = req.getParameter("username");
			String mail = req.getParameter("mail");
			String password = req.getParameter("password");
			
			try {
				if (!username.isBlank() && !mail.isBlank() && !password.isBlank()) {
					if (!mail.matches("^[a-z0-9\\._\\-]+@[a-z\\-]+\\.[a-z]{2,4}$")) {
						throw new IllegalArgumentException();
					}
					if (!password.matches("^[\\[a-zA-Z0-9&#$%*\\]+]{8,}$")) {
						throw new IllegalArgumentException();
					}
					if (!utilisateurService.checkMail(mail).isEmpty()) {
						throw new IllegalArgumentException();
					}
					if (!utilisateurService.checkUsername(username).isEmpty()) {
						throw new IllegalArgumentException();
					}
					Utilisateur u = new Utilisateur();
					u.setUsername(username);
					u.setMail(mail);
					u.setPassword(String.valueOf(password.hashCode()));
					u.setDateCreation(new Date());
					utilisateurService.add(u);
					
					resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/utilisateur?action=connexion");
				} else {
					throw new IllegalArgumentException();
				}				
			} catch (IllegalArgumentException e) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription/inscriptionFail.jsp").forward(req, resp);	
			}
		} else if (req.getParameter("action").equals("connexion")) {
			String mail = req.getParameter("mail");
			String password = req.getParameter("password");
			
			if (!mail.isBlank() && !password.isBlank()) {
				Utilisateur user = utilisateurService.get(mail, password);
				if (user != null) {
					HttpSession session = req.getSession(true);
					session.setAttribute("utilisateur", user);
					resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/home");				
				} else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion/connexionFail.jsp").forward(req, resp);	
				}				
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion/connexionFail.jsp").forward(req, resp);	
			}
		}
	}

}
