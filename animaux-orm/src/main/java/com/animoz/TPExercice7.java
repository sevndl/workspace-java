package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.animoz.modele.Soigneur;

public class TPExercice7 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			long nbSoigneurs = (Long) em.createQuery("select count(s) from Soigneur s").getSingleResult();
			System.out.println("Il y a " + nbSoigneurs + " soigneurs");
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
