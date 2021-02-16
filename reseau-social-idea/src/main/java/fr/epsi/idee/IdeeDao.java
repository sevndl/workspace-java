package fr.epsi.idee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.utilisateur.Utilisateur;

public class IdeeDao implements IIdeeDao {

	EntityManager em;
	UserTransaction utx;
	
	public IdeeDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void add(Idee i) {
		try {
			utx.begin();
			em.persist(i);
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

	public List<Idee> get() {
		return em.createQuery("select i from Idee i", Idee.class).getResultList();
	}

	public Idee getById(Long id) {
		return em.createQuery("select i from Idee i where i.id = :id", Idee.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}

}
