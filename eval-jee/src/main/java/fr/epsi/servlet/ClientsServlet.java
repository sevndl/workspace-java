package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Client;
import fr.epsi.service.IClientService;

@WebServlet("/clients")
public class ClientsServlet extends HttpServlet {

	@EJB
	private IClientService clientService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client c1 = new Client();
		c1.setAdresse("adresse 1");
		c1.setNom("client 1");
		c1.setAnimaux(null);
		this.clientService.add(c1);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clients.jsp").forward(req, resp);
	}
	
}
