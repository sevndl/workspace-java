package fr.epsi.servlet;

import java.io.IOException;
import java.net.http.HttpClient.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Produit;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/formProduct.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomProduit = req.getParameter("nomProduit");
		String cbProduit = req.getParameter("cbProduit");
		
		Produit p = new Produit();
		p.setNom(nomProduit);
		p.setCodeBarre(cbProduit);
		
		System.out.println(p.getNom());
		System.out.println(p.getCodeBarre());
	}
	
}
