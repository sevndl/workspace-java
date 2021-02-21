package fr.epsi.utilisateur;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurService implements IUtilisateurService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Utilisateur u) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		dao.add(u);
	}

	public Utilisateur get(String mail, String password) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.get(mail, password);
	}

	public List<Utilisateur> checkMail(String mail) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.checkMail(mail);
	}

	public List<Utilisateur> checkUsername(String username) {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.checkUsername(username);
	}

}
