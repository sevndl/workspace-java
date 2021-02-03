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
import fr.epsi.entite.LigneFacture;
import fr.epsi.service.IArticleService;
import fr.epsi.service.IClientService;
import fr.epsi.service.IFactureService;
import fr.epsi.service.ILigneFactureService;

@WebServlet("/factures")
public class FacturesServlet extends HttpServlet {

	@EJB
	private IFactureService factureService;
	
	@EJB
	private IClientService clientService;
	
	@EJB
	private IArticleService articleService;
	
	@EJB
	private ILigneFactureService ligneFactureService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			
			// je r�cup�re la liste des factures
			req.setAttribute("factures", factureService.getAllFactures());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/factures.jsp").forward(req, resp);		
			
		} else if (req.getParameter("action").equals("ajouter")) {
			
			// je r�cup�re la liste des clients et dse articles pour alimenter les dropdowns
			// de cette mani�re, l'utilisateur n'a le choix qu'entre les donn�es pr�sentes dans la base
			// sans possibilit� d'ajouter des donn�es erron�es ou non acceptables
			req.setAttribute("clients", clientService.getAllClients());
			req.setAttribute("articles", articleService.getAllArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/facturesFormulaire.jsp").forward(req, resp);	
			
		} else if (req.getParameter("action").equals("detail")) {
			
			// je r�cup�re l'id de la facture pour aller la chercher en base
			// je r�cup�re le client associ�, ainsi que toutes les lignes de la facture � cet id
			Long id = Long.parseLong(req.getParameter("id"));
			req.setAttribute("facture", factureService.getFactureById(id));
			req.setAttribute("client", clientService.getClientByFactureId(id));
			req.setAttribute("lignes", ligneFactureService.getLigneFactureByFactureId(id));
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/factureDetail.jsp").forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
			Facture nouvelleFacture = new Facture();
			String numero = req.getParameter("numero");
			Double prix = (double) 0;
			List<Facture> allFactures = factureService.getAllFactures();
			LigneFacture lf1 = new LigneFacture();
			LigneFacture lf2 = new LigneFacture();
			LigneFacture lf3 = new LigneFacture();
			LigneFacture lf4 = new LigneFacture();
			
			if (numero.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			for (Facture f : allFactures) {
				if (numero.equals(f.getNumero())) {
					throw new IllegalArgumentException();
				}
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
			Long qte1 = Long.parseLong(qte1Str);
			if (qte1 < 0) {
				throw new IllegalArgumentException();
			} 
			if (!article1.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article1));
				prix += a.getPrix() * qte1;
				lf1.setFacture(nouvelleFacture);
				lf1.setArticle(a);
				lf1.setQte(qte1);
				lf1.setPrix(a.getPrix() * qte1);
			}			
			
			String article2 = req.getParameter("article2");
			String qte2Str = req.getParameter("qte2");
			if (qte2Str.isEmpty()) { qte2Str = "1"; }
			Long qte2 = Long.parseLong(qte2Str);
			if (qte2 < 0) {
				throw new IllegalArgumentException();
			} 
			if (!article2.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article2));
				prix += a.getPrix() * qte2;
				lf2.setFacture(nouvelleFacture);
				lf2.setArticle(a);
				lf2.setQte(qte2);
				lf2.setPrix(a.getPrix() * qte2);
			}			
			
			String article3 = req.getParameter("article3");
			String qte3Str = req.getParameter("qte3");
			if (qte3Str.isEmpty()) { qte3Str = "1"; }
			Long qte3 = Long.parseLong(qte3Str);
			if (qte3 < 0) {
				throw new IllegalArgumentException();
			} 
			if (!article3.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article3));
				prix += a.getPrix() * qte3;
				lf3.setFacture(nouvelleFacture);
				lf3.setArticle(a);
				lf3.setQte(qte3);
				lf3.setPrix(a.getPrix() * qte3);
			}			
			
			String article4 = req.getParameter("article4");
			String qte4Str = req.getParameter("qte4");
			if (qte4Str.isEmpty()) { qte4Str = "1"; }
			Long qte4 = Long.parseLong(qte4Str);
			if (Integer.parseInt(qte4Str) < 0) {
				throw new IllegalArgumentException();
			} 
			if (!article4.isEmpty()) {
				Article a = articleService.getArticleById(Long.parseLong(article4));
				prix += a.getPrix() * qte4;
				lf4.setFacture(nouvelleFacture);
				lf4.setArticle(a);
				lf4.setQte(qte4);
				lf4.setPrix(a.getPrix() * qte4);
			}
			
			if (qte1Str.isEmpty() && qte2Str.isEmpty() && qte3Str.isEmpty() && qte4Str.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			nouvelleFacture.setNumero(numero);
			nouvelleFacture.setPrix(prix);
			factureService.add(nouvelleFacture);
			
			// j'ajoute � ligneFacture seulement les champs article_n s�lectionn�s
			if (!qte1Str.isEmpty() && !article1.isEmpty()) { ligneFactureService.add(lf1); }
			if (!qte2Str.isEmpty() && !article2.isEmpty()) { ligneFactureService.add(lf2); }
			if (!qte3Str.isEmpty() && !article3.isEmpty()) { ligneFactureService.add(lf3); }
			if (!qte4Str.isEmpty() && !article4.isEmpty()) { ligneFactureService.add(lf4); }
			
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=liste");			
		} catch (ParseException e) {
			// si une exception est lev�e, je renvoie sur le formulaire vide sans faire l'ajout
			// une exception est lev�e si :
			// 		- le num�ro est vide
			// 		- le num�ro existe d�j� dans la base -> d'o� la r�cup�ration de tous les articles
			//  	- le nom du client est vide
			//  	- aucun article n'est s�lectionn�
			//  	- la date s�lectionn�e est pass�e ou vide
			//  	- la quantit� s�lectionn�e pour un article est n�gative
			
			// si le champ quantit� n'est pas modifi�, sa valeur par d�faut est d�finie � 1
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		} catch (IllegalArgumentException e) {
			// idem ici
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=ajouter");			
		}
		
	}
	
}
