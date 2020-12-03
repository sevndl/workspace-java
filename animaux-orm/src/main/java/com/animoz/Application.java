package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
  
	public static void main(String[] args) {
    // création de l'entitymanagerfactory et de l'entitymanager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
    EntityManager em = emf.createEntityManager();
		
		try {
			// TODO ajouter du code ici
		} finally {
			em.close();
			emf.close();
		}
	}

}
