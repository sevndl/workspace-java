package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class TPExercice4 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			List<Espece> especes = em.createQuery("select e from Espece e order by e.nom", Espece.class).getResultList();
			for (Espece e : especes) {
				System.out.println(e.getNom());
			}
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
