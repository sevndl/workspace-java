package fr.epsi.servlet;

import java.io.IOException;

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
			req.setAttribute("articles", articleService.getAllArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("ajouter")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articlesFormulaire.jsp").forward(req, resp);	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		Double prix = Double.parseDouble(req.getParameter("prix"));
		
		Article nouvelArticle = new Article();
		nouvelArticle.setNom(nom);
		nouvelArticle.setPrix(prix);
		articleService.add(nouvelArticle);
		resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/articles?action=liste");
	}
	
}
