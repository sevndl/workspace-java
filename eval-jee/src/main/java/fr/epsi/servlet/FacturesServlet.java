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
			
			if (numero.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			if (!req.getParameter("client").isEmpty()) {
				Client client = clientService.getClientById(Long.parseLong(req.getParameter("client")));
				nouvelleFacture.setClient(client);				
			} else {
				throw new IllegalArgumentException();
			}
			
			String dateStr = req.getParameter("dateStr");
			if (!dateStr.isEmpty()) {
				Date date = formatter.parse(dateStr);				
				if (!date.after(new Date(System.currentTimeMillis()-24*60*60*1000))) {
					throw new IllegalArgumentException();
				}
				nouvelleFacture.setDate(date);
			} else {
				throw new IllegalArgumentException();
			}
			
			String article1 = req.getParameter("article1");
			String qte1Str = req.getParameter("qte1");
			if (qte1Str.isEmpty()) { qte1Str = "1"; }
			if (Integer.parseInt(qte1Str) < 0) {
				throw new IllegalArgumentException();
			} 
			int qte1 = Integer.parseInt(qte1Str);
			if (!article1.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article1));
				prix += a.getPrix() * qte1;
			}			
			
			String article2 = req.getParameter("article2");
			String qte2Str = req.getParameter("qte2");
			if (qte2Str.isEmpty()) { qte2Str = "1"; }
			if (Integer.parseInt(qte2Str) < 0) {
				throw new IllegalArgumentException();
			} 
			int qte2 = Integer.parseInt(qte2Str);
			if (!article2.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article2));
				prix += a.getPrix() * qte2;
			}			
			
			String article3 = req.getParameter("article3");
			String qte3Str = req.getParameter("qte3");
			if (qte3Str.isEmpty()) { qte3Str = "1"; }
			if (Integer.parseInt(qte3Str) < 0) {
				throw new IllegalArgumentException();
			} 
			int qte3 = Integer.parseInt(qte3Str);
			if (!article3.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article3));
				prix += a.getPrix() * qte3;
			}			
			
			String article4 = req.getParameter("article4");
			String qte4Str = req.getParameter("qte4");
			if (qte4Str.isEmpty()) { qte4Str = "1"; }
			if (Integer.parseInt(qte4Str) < 0) {
				throw new IllegalArgumentException();
			} 
			int qte4 = Integer.parseInt(qte4Str);
			if (!article4.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article4));
				prix += a.getPrix() * qte4;
			}
			
			if (qte1Str.isEmpty() && qte2Str.isEmpty() && qte3Str.isEmpty() && qte4Str.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			nouvelleFacture.setNumero(numero);
			nouvelleFacture.setPrix(prix);
			factureService.add(nouvelleFacture);
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=liste");			
		} catch (ParseException e) {
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		} catch (IllegalArgumentException e) {
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		}
		
	}
	
}
