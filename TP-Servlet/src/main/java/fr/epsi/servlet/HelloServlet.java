package fr.epsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        PrintWriter out = resp.getWriter();
	        out.write("<html>");
	        out.write("<head>");
	        out.write("<title>Web app</title>");
	        out.write("</head>");
	        out.write("<body>");
	        out.write("<h3 style='color:red'>Titre</h3>");
	        out.write("</body>");
	        out.write("</html>");
	}
	
}
