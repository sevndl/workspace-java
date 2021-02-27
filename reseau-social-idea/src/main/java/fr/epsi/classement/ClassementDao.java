package fr.epsi.classement;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

public class ClassementDao implements IClassementDao {

	EntityManager em;
	UserTransaction utx;
	
	public ClassementDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

}
