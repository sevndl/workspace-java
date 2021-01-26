package fr.epsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// si on veut éviter d'écrire dans un fichier .xml => il remplace tout le contenu de web.xml
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idClient = Integer.parseInt(req.getParameter("id"));
		System.out.println(idClient);
		
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>Web app</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h3 style='color:red'>Titre</h3>");
        out.write("<p>Bonjour client n°" + idClient + "</p>");
        out.write("</body>");
        out.write("</html>");
	}
	
}
