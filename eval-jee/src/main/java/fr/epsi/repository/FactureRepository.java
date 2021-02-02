package fr.epsi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

public class FactureRepository implements IFactureRepository {
	EntityManager em;
	UserTransaction utx;
	
	public FactureRepository(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Facture> getAllFactures() {
		return em.createQuery("select f from Facture f", Facture.class).getResultList();
	}
	
	public void add(Facture facture) {
		try {
			utx.begin();
			em.persist(facture);
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

	public Facture getFactureById(Long id) {
		return em.createQuery("select f from Facture f where f.id = :id", Facture.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}
}
