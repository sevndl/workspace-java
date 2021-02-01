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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Article a1 = new Article();
		a1.setNom("article 1");
		a1.setPrix((double) 10);
		a1.setLignesFacture(null);
		articleService.add(a1);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articles.jsp").forward(req, resp);
	}
	
}
