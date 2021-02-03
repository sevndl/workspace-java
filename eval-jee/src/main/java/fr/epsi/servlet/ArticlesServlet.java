package fr.epsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.IArticleService;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {

	@EJB
	private IArticleService articleService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			
			// je r�cup�re la liste des articles
			req.setAttribute("articles", articleService.getAllArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);			
			
		} else if (req.getParameter("action").equals("ajouter")) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articlesFormulaire.jsp").forward(req, resp);

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("ajouter")) {
			try {
				String nom = req.getParameter("nom");
				Double prix = Double.parseDouble(req.getParameter("prix"));
				List<Article> allArticles = articleService.getAllArticles();
				
				if (nom.isEmpty()) {
					throw new IllegalArgumentException();
				}
				
				for (Article a : allArticles) {
					if (nom.equals(a.getNom())) {
						throw new IllegalArgumentException();
					}					
				}
				
				if (prix < 0) {
					throw new IllegalArgumentException();
				}
				
				Article nouvelArticle = new Article();
				nouvelArticle.setNom(nom);
				nouvelArticle.setPrix(prix);
				articleService.add(nouvelArticle);
				resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/articles?action=liste");
			} catch(IllegalArgumentException e) {
				// si une exception est lev�e, je renvoie sur le formulaire vide sans faire l'ajout
				// une exception est lev�e si :
				// 		- le nom est vide
				// 		- le nom existe d�j� dans la base -> d'o� la r�cup�ration de tous les articles
				//  	- le prix est n�gatif
				resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/articles?action=ajouter");
			}			
		}
	}
	
}
