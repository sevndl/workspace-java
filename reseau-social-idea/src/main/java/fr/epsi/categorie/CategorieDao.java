package fr.epsi.categorie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class CategorieDao implements ICategorieDao {

	EntityManager em;
	UserTransaction utx;
	
	public CategorieDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void add(Categorie c) {
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

	public List<Categorie> get() {
		return em.createQuery("select c from Categorie c", Categorie.class).getResultList();
	}

	public Categorie getById(Long id) {
		return em.createQuery("select c from Categorie c where c.id = :id", Categorie.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}

}
