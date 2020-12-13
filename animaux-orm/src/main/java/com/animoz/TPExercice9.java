package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;

public class TPExercice9 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			List<Animal> animaux = em.createQuery("select a from Animal a where a.especeId.nom = 'Artiodactyla'", Animal.class).getResultList();
			for (Animal animal : animaux) {
				System.out.println(animal.getNom());
			}
			
		} finally {
			em.close();
			emf.close();
		}
	}

}