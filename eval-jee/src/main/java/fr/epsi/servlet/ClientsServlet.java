package fr.epsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Client;
import fr.epsi.service.IClientService;
import fr.epsi.service.IFactureService;

@WebServlet("/clients")
public class ClientsServlet extends HttpServlet {

	@EJB
	private IClientService clientService;
	
	@EJB
	private IFactureService factureService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("action").equals("liste")) {
			
			// je r�cup�re la liste des clients
			req.setAttribute("clients", clientService.getAllClients());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clients.jsp").forward(req, resp);			
			
		} else if (req.getParameter("action").equals("ajouter")) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clientsFormulaire.jsp").forward(req, resp);
			
		} else if (req.getParameter("action").equals("detail")) {

			// je r�cup�re seulement le client � l'id voulu
			// ainsi que la liste des factures qui lui sont attribu�es
			Long id = Long.parseLong(req.getParameter("id"));
			req.setAttribute("client", clientService.getClientById(id));
			req.setAttribute("factures", factureService.getFactureByClientId(id));
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clientDetail.jsp").forward(req, resp);	
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nom = req.getParameter("nom");
			String adresse= req.getParameter("adresse");
			List<Client> allClients = clientService.getAllClients();
			
			if (nom.isEmpty()) {
				throw new IllegalArgumentException();
			}
			
			for (Client c : allClients) {
				if (nom.equals(c.getNom())) {
					throw new IllegalArgumentException();
				}
			}
			
			if (!adresse.matches("^[0-9]{1,4}\\ [\\ \\-a-zA-Z]+[0-9]{5}\\ [\\ \\-a-zA-Z]+$")) {
				throw new IllegalArgumentException();
			}
			
			Client nouveauClient = new Client();
			nouveauClient.setNom(nom);
			nouveauClient.setAdresse(adresse);
			clientService.add(nouveauClient);		
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/clients?action=liste");	
		} catch (IllegalArgumentException e) {
			// si une exception est lev�e, je renvoie sur le formulaire vide sans faire l'ajout
			// une exception est lev�e si :
			// 		- le nom est vide
			// 		- le nom existe d�j� dans la base -> d'o� la r�cup�ration de tous les clients
			//  	- l'adresse ne respecte pas le format 
			resp.sendRedirect("http://localhost:8080/eval-jee-0.0.1-SNAPSHOT/clients?action=ajouter");			
		}
	}
	
}
