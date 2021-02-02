package fr.epsi.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;
import fr.epsi.service.IArticleService;
import fr.epsi.service.IClientService;
import fr.epsi.service.IFactureService;

@WebServlet("/factures")
public class FacturesServlet extends HttpServlet {

	@EJB
	private IFactureService factureService;
	
	@EJB
	private IClientService clientService;
	
	@EJB
	private IArticleService articleService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			req.setAttribute("factures", factureService.getAllFactures());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/factures.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("ajouter")) {
			req.setAttribute("clients", clientService.getAllClients());
			req.setAttribute("articles", articleService.getAllArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/facturesFormulaire.jsp").forward(req, resp);	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
			Facture nouvelleFacture = new Facture();
			String numero = req.getParameter("numero");
			Double prix = (double) 0;
			
			if (!req.getParameter("client").equals("")) {
				Client client = clientService.getClientById(Long.parseLong(req.getParameter("client")));
				nouvelleFacture.setClient(client);				
			}
			
			String dateStr = req.getParameter("dateStr");
			if (!dateStr.isEmpty()) {
				Date date = formatter.parse(dateStr);				
				if (!date.after(new Date(System.currentTimeMillis()-24*60*60*1000))) {
					throw new IllegalArgumentException();
				}
				nouvelleFacture.setDate(date);
			}			
			
			String article1 = req.getParameter("article1");
			if (!article1.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article1));
				prix += a.getPrix();
			}			
			
			String article2 = req.getParameter("article2");
			if (!article2.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article2));
				prix += a.getPrix();
			}			
			
			String article3 = req.getParameter("article3");
			if (!article3.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article3));
				prix += a.getPrix();
			}			
			
			String article4 = req.getParameter("article4");
			if (!article4.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article4));
				prix += a.getPrix();
			}
			
			nouvelleFacture.setNumero(numero);
			nouvelleFacture.setPrix(prix);
			factureService.add(nouvelleFacture);
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=liste");			
		} catch (ParseException e) {
			e.printStackTrace();
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		} catch (IllegalArgumentException e) {
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		}
		
	}
	
}
