package fr.epsi.classement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.idee.Idee;

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

}
