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

	public List<Utilisateur> get() {
		IUtilisateurDao dao = new UtilisateurDao(em, utx);
		return dao.get();
	}

}
