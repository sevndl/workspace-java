package fr.epsi.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Facture;
import fr.epsi.service.IFactureService;

@WebServlet("/factures")
public class FacturesServlet extends HttpServlet {

	@EJB
	private IFactureService factureService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			req.setAttribute("factures", factureService.getAllFactures());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/factures.jsp").forward(req, resp);			
		} else if (req.getParameter("action").equals("ajouter")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/facturesFormulaire.jsp").forward(req, resp);	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
		try {
			Facture nouvelleFacture = new Facture();
			String numero = req.getParameter("numero");
			Double prix = Double.parseDouble(req.getParameter("prix"));
			String dateStr = req.getParameter("dateStr");
			Date date = formatter.parse(dateStr);
			nouvelleFacture.setNumero(numero);
			nouvelleFacture.setDate(date);
			nouvelleFacture.setPrix(prix);
			factureService.add(nouvelleFacture);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/factures?action=liste");
	}
	
}
