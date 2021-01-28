package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Produit;
import fr.epsi.service.IProduitService;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {
	
	@EJB
	private IProduitService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/FormProduct.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomProduit = req.getParameter("nomProduit");
		String cbProduit = req.getParameter("cbProduit");
		Produit p = new Produit();
		
		p.setNom(nomProduit);
		p.setCodeBarre(cbProduit);
		service.createProduit(p);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/HomePage.jsp").forward(req, resp);
	}
	
}
