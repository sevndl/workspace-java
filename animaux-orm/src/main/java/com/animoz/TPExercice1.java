package com.animoz;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class TPExercice1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		Scanner in = new Scanner(System.in);
		System.out.print("Nom de l'espèce à ajouter à la base de données : ");
		String nom = in.nextLine();

		try {
			
			Espece espece = new Espece();
			espece.setNom(nom);
			em.getTransaction().begin();
			em.persist(espece);
			em.getTransaction().commit();
			
			System.out.println(espece.getNom());
			System.out.println(espece.getId());
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
