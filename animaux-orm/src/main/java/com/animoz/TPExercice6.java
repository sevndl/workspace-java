package com.animoz;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;

public class TPExercice6 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Nom de l'animal recherché : ");
		String nom = in.nextLine();
		nom = nom.toLowerCase();
		
		try {
			
			List<Animal> animal = em.createQuery("select a from Animal a where LOWER(a.nom) = :nom", Animal.class)
									.setParameter("nom", nom)
									.getResultList();
			if (animal.isEmpty()) {
				throw new IllegalArgumentException("L'animal " + nom + " n'existe pas en base.");
			}
			for (Animal a : animal) {
				System.out.println(a.getId());
				System.out.println(a.getNom());
				System.out.println(a.getOrigine());
				System.out.println(a.getDescription());
				System.out.println(a.getRegime());
			}
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}

}
