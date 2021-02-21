package fr.epsi.commentaire;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;

public class CommentaireDao implements ICommentaireDao {
	
	EntityManager em;
	UserTransaction utx;
	
	public CommentaireDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void add(Commentaire c) {
		try {
			utx.begin();
			em.persist(c);
			utx.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	public List<Commentaire> get() {
		return em.createQuery("select c from Commentaire c", Commentaire.class).getResultList();
	}

	public List<Commentaire> getByIdee(Idee idee) {
		return em.createQuery("select c from Commentaire c where c.idee = :idee", Commentaire.class)
				 .setParameter("idee", idee)
				 .getResultList();
	}

}
