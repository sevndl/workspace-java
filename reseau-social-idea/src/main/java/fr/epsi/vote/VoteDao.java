package fr.epsi.vote;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

public class VoteDao implements IVoteDao {

	EntityManager em;
	UserTransaction utx;
	
	public VoteDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void add(Vote v) {
		try {
			utx.begin();
			em.persist(v);
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

	public List<Vote> getByUtilisateur(Utilisateur u) {
		return em.createQuery("select v from Vote v where v.utilisateur = :u", Vote.class)
				 .setParameter("u", u)
				 .getResultList();
	}

	public List<Vote> getByIdee(Idee i) {
		return em.createQuery("select v from Vote v where v.idee = :i", Vote.class)
				 .setParameter("i", i)
				 .getResultList();
	}

	public List<Vote> getByUtilisateurAndIdee(Utilisateur u, Idee i) {
		return em.createQuery("select v from Vote v where v.utilisateur = :u and v.idee = :i", Vote.class)
				 .setParameter("u", u)
				 .setParameter("i", i)
				 .getResultList();
	}

}
