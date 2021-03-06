package com.animoz;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Population;

public class TPExercice10 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in, Charset.forName("utf-8"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entrez le nom d'un animal :");
		String nomAnimal = scanner.next();
		System.out.println("Entrez maintenant le nombre d'individus de cette population :");
		Long nbIndividus = scanner.nextLong();
		if (nbIndividus < 0 ) {
			scanner.close();
			throw new IllegalArgumentException();
		}
		
		try {
			
			Animal animal = em.createQuery("select a from Animal a where nom = :nom", Animal.class)
							  .setParameter("nom", nomAnimal)
							  .getSingleResult();
			Animal idAnimal = em.getReference(Animal.class, animal.getId());
			
			Population population = new Population();
			population.setNombreIndividus(nbIndividus);
			population.setAnimal(idAnimal);
			em.getTransaction().begin();
			em.persist(population);
			em.getTransaction().commit();
			
		} catch (NoResultException e) {
			System.out.println("L'animal demandé n'existe pas dans la base de données.");
			main(args);
		} catch (IllegalArgumentException e) {
			System.out.println("Le nombre d'individus ne peut pas être négatif.");
			main(args);
		} finally {
			em.close();
			emf.close();
			scanner.close();
		}
	}

}