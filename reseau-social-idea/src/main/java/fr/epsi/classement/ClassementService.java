package fr.epsi.classement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClassementService implements IClassementService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public List<Idee> getTop3IdeesPlusDeVotes() {
		IClassementDao dao = new ClassementDao(em, utx);
		return dao.getTop3IdeesPlusDeVotes();
	}

	public List<Utilisateur> getTop3UtilisateursPlusIdees() {
		IClassementDao dao = new ClassementDao(em, utx);
		return dao.getTop3UtilisateursPlusIdees();
	}

	public List<Idee> getTop3IdeesMieuxNotees() {
		IClassementDao dao = new ClassementDao(em, utx);
		return dao.getTop3IdeesMieuxNotees();
	}

}
