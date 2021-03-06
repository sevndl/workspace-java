package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class ApplicationEspeceDemo {

	public static void main(String[] args) {
		// création de l'entitymanagerfactory et de l'entitymanager
		// "animaux" correspond à la connexion "animaux" du fichier persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();

		try {
			// Espece espece = em.find(Espece.class, 1L); // L = Long --> c'est le type du champ id dans Espece.java
			// System.out.println(espece.getNom());
			
			// pour modifier la base de données, il faut commencer une transaction 
			// (peut contenir plusieurs requêtes)
			// et il faut commit à la fin de la transaction si tout se passe bien
			// sinon rollback
			em.getTransaction().begin();
			Espece espece = new Espece();
			espece.setNom("Bovidé"); // on ne set pas l'id puisqu'il s'auto-incrémente
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
