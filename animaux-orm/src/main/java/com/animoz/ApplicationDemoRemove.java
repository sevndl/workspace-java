package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class ApplicationDemoRemove {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Espece espece = em.find(Espece.class, 5L);
			espece.setNom("Aligator");
			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}
	}

}
