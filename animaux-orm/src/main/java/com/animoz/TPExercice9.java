package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;

public class TPExercice9 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Animal animal = em.find(Animal.class, 1L);
			System.out.println(animal.getEspece().getNom());
			
		} finally {
			em.close();
			emf.close();
		}
	}

}