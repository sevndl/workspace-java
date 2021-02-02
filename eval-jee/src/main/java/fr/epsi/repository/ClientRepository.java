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

public class ClientRepository implements IClientRepository {
	
	EntityManager em;
	UserTransaction utx;
	
	public ClientRepository(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Client> getAllClients() {
		return em.createQuery("select c from Client c", Client.class).getResultList();
	}
	
	public Client getClientById(Long id) {
		return em.createQuery("select c from Client c where c.id = :id", Client.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}

	public void add(Client client) {
		try {
			utx.begin();
			em.persist(client);
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

}
