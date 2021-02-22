package fr.epsi.vote;

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
public class VoteService implements IVoteService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Vote v) {
		IVoteDao dao = new VoteDao(em, utx);
		dao.add(v);
	}

	public List<Vote> getByUtilisateur(Utilisateur u) {
		IVoteDao dao = new VoteDao(em, utx);
		return dao.getByUtilisateur(u);
	}

	public List<Vote> getByIdee(Idee i) {
		IVoteDao dao = new VoteDao(em, utx);
		return dao.getByIdee(i);
	}

	public List<Vote> getByUtilisateurAndIdee(Utilisateur u, Idee i) {
		IVoteDao dao = new VoteDao(em, utx);
		return dao.getByUtilisateurAndIdee(u, i);
	}

}
