package com.animoz;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;

public class TPExercice2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Id de l'animal : ");
		long id = in.nextLong();

		try {
			
			Animal animal = em.find(Animal.class, id);
			System.out.println(animal.getId());
			System.out.println(animal.getNom());
			System.out.println(animal.getOrigine());
			System.out.println(animal.getDescription());
			System.out.println(animal.getRegime());
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
