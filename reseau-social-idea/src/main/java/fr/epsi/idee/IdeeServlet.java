package fr.epsi.idee;

import java.util.List;
import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.categorie.Categorie;
import fr.epsi.categorie.ICategorieService;
import fr.epsi.commentaire.Commentaire;
import fr.epsi.commentaire.ICommentaireService;
import fr.epsi.utilisateur.Utilisateur;
import fr.epsi.vote.IVoteService;
import fr.epsi.vote.Vote;

@WebServlet("/idee")
public class IdeeServlet extends HttpServlet {

	@EJB
	private IIdeeService ideeService;
	
	@EJB
	private ICategorieService categorieService;
	
	@EJB
	private ICommentaireService commentaireService;
	
	@EJB
	private IVoteService voteService;
	
	private Boolean erreur = false;

	public Boolean getErreur() {
		return this.erreur;
	}

	public void setErreur(Boolean erreur) {
		this.erreur = erreur;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("action").equals("liste")) {
			
			req.setAttribute("idees", ideeService.get());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/idees.jsp").forward(req, resp);
			
		} else if (req.getParameter("action").equals("ajouter")) {
			
			req.setAttribute("categories", categorieService.get());
			if (this.getErreur().equals(false)) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterIdee.jsp").forward(req, resp);
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ajouterIdeeFail.jsp").forward(req, resp);
			}
			
		} else if (req.getParameter("action").equals("detail")) {
			
			Long id = Long.parseLong(req.getParameter("id"));
			Idee idee = ideeService.getById(id);
			HttpSession session = req.getSession();
			Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
			Boolean peutVoter = true;
			
			if (!u.equals(null)) {
				int nbVotes = voteService.getByUtilisateurAndIdee(u, idee).size();				
				if (nbVotes > 0) { peutVoter = false; }
			}
			
			req.setAttribute("peutVoter", peutVoter);
			req.setAttribute("commentaires", commentaireService.getByIdee(idee));
			req.setAttribute("idee", idee);
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeDetail.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("action").equals("ajouter")) {
			
			String titre = req.getParameter("titre");
			String description = req.getParameter("description");
			String categorie = req.getParameter("categorie");
			String image = req.getParameter("image");
			String imageParDefaut = "http://www.slate.fr/sites/default/files/styles/1060x523/public/hide_the_pain_harold_meme_andras_arato.jpg";
			
			try {
				if (!titre.isBlank() && !description.isBlank()) {
					
					HttpSession session = req.getSession();
					Utilisateur userConnect = (Utilisateur) session.getAttribute("utilisateur");
					Idee i = new Idee();
					i.setTitre(titre);
					i.setDescription(description);
					i.setDate(new Date());
					if (!image.isBlank()) { i.setImage(image); } else { i.setImage(imageParDefaut);	}
					if (!categorie.isBlank()) {
						Categorie c = categorieService.getById(Long.parseLong(categorie));
						i.setCategorie(c);
					}
					if (!userConnect.equals(null)) {
						i.setUtilisateur(userConnect);
					}
					
					ideeService.add(i);
					this.setErreur(false);
					resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=liste");
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				this.setErreur(true);
				resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=ajouter");
			}
			
		} else if (req.getParameter("action").equals("commentaire")) {
			
			String commentaire = req.getParameter("commentaire");
			String id = req.getParameter("id");
			Idee idee = ideeService.getById(Long.parseLong(id));
			
			if (!commentaire.isBlank()) {
				HttpSession session = req.getSession();
				Utilisateur userConnect = (Utilisateur) session.getAttribute("utilisateur");
				
				Commentaire c = new Commentaire();
				if (!userConnect.equals(null)) {
					c.setAuteur(userConnect);
				}
				c.setIdee(idee);
				c.setContenu(commentaire);
				c.setDateCreation(new Date());	
				commentaireService.add(c);
			}
			resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=detail&id=" + id);
		} else if (req.getParameter("action").equals("vote")) {
			
			String vote = req.getParameter("vote");
			String id = req.getParameter("id");
			Idee idee = ideeService.getById(Long.parseLong(id));
			
			HttpSession session = req.getSession();
			Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");

			int nbVotes = voteService.getByUtilisateurAndIdee(u, idee).size();
			
			if (nbVotes > 0) {
				resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=detail&id=" + id);
			} else {
				Vote v = new Vote();
				v.setIdee(idee);
				v.setUtilisateur(u);
				
				if (vote.equals(Vote.vote.top.toString())) {
					v.setTypeVote(Vote.vote.top);
					ideeService.addTopById(Long.parseLong(id));
				} else if (vote.equals(Vote.vote.flop.toString())) {
					v.setTypeVote(Vote.vote.flop);
					ideeService.addFlopById(Long.parseLong(id));
				}
				voteService.add(v);
				resp.sendRedirect("http://localhost:8080/reseau-social-idea-0.0.1-SNAPSHOT/idee?action=detail&id=" + id);
			}
			
		}
	}

}
