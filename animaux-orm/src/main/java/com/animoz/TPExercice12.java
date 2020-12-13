package com.animoz;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Population;

public class TPExercice12 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in, Charset.forName("utf-8"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entrez le nom d'une espèce :");
		String nomEspece = scanner.next();
		
		try {
			
			Long nbIndividusTotal = em.createQuery("select sum(p.nombreIndividus) from Population p join p.animalId a join a.especeId e where lower(e.nom) = lower(:nom)", Long.class)
									  .setParameter("nom", nomEspece)
									  .getSingleResult();
			if (nbIndividusTotal == null) {
				System.out.println("L'espèce demandée n'existe pas en base ou n'a pas de population attribuée.");
			} else {
				System.out.println("L'espèce " + nomEspece + " a une population de " + nbIndividusTotal + " individus");
			}
			
		} finally {
			em.close();
			emf.close();
			scanner.close();
		}
	}

}