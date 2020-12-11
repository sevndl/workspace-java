package com.animoz;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Population;

public class TPExercice11 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in, Charset.forName("utf-8"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entrez le nom d'un animal :");
		String nomAnimal = scanner.next();
		
		try {
			
			Long nbIndividusTotal = em.createQuery("select sum(p.nombreIndividus) from Population p join p.animalId a where lower(a.nom) = lower(:nom)", Long.class)
									  .setParameter("nom", nomAnimal)
									  .getSingleResult();
			System.out.println("L'animal " + nomAnimal + " a une population de " + nbIndividusTotal + " individus.");
			
		} finally {
			em.close();
			emf.close();
			scanner.close();
		}
	}

}