package fr.epsi.classement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;
import fr.epsi.utilisateur.Utilisateur;

public class ClassementDao implements IClassementDao {

	EntityManager em;
	UserTransaction utx;
	
	public ClassementDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Idee> getTop3IdeesPlusDeVotes() {
		return em.createQuery("select i from Idee i order by (i.nbTop + i.nbFlop) desc", Idee.class)
				 .setMaxResults(3)
				 .getResultList();
	}

	public List<Utilisateur> getTop3UtilisateursPlusIdees() {
		return em.createQuery("select u from Utilisateur u join u.idees i group by i.utilisateur order by count(u) desc, u.dateCreation asc", Utilisateur.class)
				 .setMaxResults(3)
				 .getResultList();
	}

	public List<Idee> getTop3IdeesMieuxNotees() {
		return em.createQuery("select i from Idee i order by ((i.nbTop / i.nbVotes) * 100) desc, i.nbVotes desc, i.date asc", Idee.class)
				 .setMaxResults(3)
				 .getResultList();
	}

}
