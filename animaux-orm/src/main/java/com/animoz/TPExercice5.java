package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;

public class TPExercice5 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			// il faut voir ça côté objet et pas côté SQL
			List<Animal> animal = em.createQuery("select a from Animal a where a.regime = 'carnivore'", Animal.class).getResultList();
			for (Animal a : animal) {
				System.out.println(a.getNom());
			}
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
