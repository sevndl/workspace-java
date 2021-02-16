package fr.epsi.idee;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Categorie;

@WebServlet("/idee")
public class IdeeServlet extends HttpServlet {

	@EJB
	private IIdeeService ideeService;
	private Boolean erreur = false;

	public Boolean getErreur() {
		return this.erreur;
	}

	public void setErreur(Boolean erreur) {
		this.erreur = erreur;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			req.setAttribute("idees", ideeService.get());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/idees.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("ajouter")) {
			if (this.getErreur().equals(false)) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterIdee.jsp").forward(req, resp);
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterIdeeFail.jsp").forward(req, resp);
			}
		} else if (req.getParameter("action").equals("detail")) {
			req.setAttribute("idee", ideeService.getById(Long.parseLong(req.getParameter("id"))));
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeDetail.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("ajouter")) {
			String titre = req.getParameter("titre");
			String description = req.getParameter("description");
			String categorie = req.getParameter("categorie");
			String image = req.getParameter("image");
			String imageParDefaut = "http://www.slate.fr/sites/default/files/styles/1060x523/public/hide_the_pain_harold_meme_andras_arato.jpg";
			
			try {
				if (!titre.isBlank() && !description.isBlank()) {
					Idee i = new Idee();
					i.setTitre(titre);
					i.setDescription(description);
					if (!image.isBlank()) { i.setImage(image); } else { i.setImage(imageParDefaut);	}
					if (!categorie.isBlank()) { 
						Categorie c = new Categorie();
						c.setNom(categorie);
						i.setCategorie(c);
					}
					
					ideeService.add(i);
					this.setErreur(false);
					resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=liste");
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				this.setErreur(true);
				resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=ajouter");
			}
			
		}
	}

}
