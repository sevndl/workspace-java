package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class TPExercice3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			// il faut voir ça côté objet et pas côté SQL
			List<Espece> especes = em.createQuery("select e from Espece e", Espece.class).getResultList();
			for (Espece e : especes) {
				System.out.println(e.getNom());
			}
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
