package fr.epsi.utilisateur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class UtilisateurDao implements IUtilisateurDao {

	EntityManager em;
	UserTransaction utx;
	
	public UtilisateurDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void add(Utilisateur u) {
		try {
			utx.begin();
			em.persist(u);
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

	public Utilisateur get(String mail, String password) {
		List<Utilisateur> users = em.createQuery("select u from Utilisateur u where u.mail = :mail and u.password = :password", Utilisateur.class)
				 .setParameter("mail", mail)
				 .setParameter("password", String.valueOf(password.hashCode()))
				 .getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public List<Utilisateur> checkMail(String mail) {
		return em.createQuery("select u from Utilisateur u where u.mail = :mail", Utilisateur.class)
				 .setParameter("mail", mail)
				 .getResultList();
	}

	public List<Utilisateur> checkUsername(String username) {
		return em.createQuery("select u from Utilisateur u where u.username = :username", Utilisateur.class)
				 .setParameter("username", username)
				 .getResultList();
	}

}
