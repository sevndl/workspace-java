package fr.epsi.commentaire;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentaireService implements ICommentaireService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Commentaire c) {
		ICommentaireDao dao = new CommentaireDao(em, utx);
		dao.add(c);
	}

	public List<Commentaire> get() {
		ICommentaireDao dao = new CommentaireDao(em, utx);
		return dao.get();
	}

	public List<Commentaire> getByIdee(Idee idee) {
		ICommentaireDao dao = new CommentaireDao(em, utx);
		return dao.getByIdee(idee);
	}

}
