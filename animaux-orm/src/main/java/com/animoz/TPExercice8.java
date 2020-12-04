package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Soigneur;

public class TPExercice8 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Soigneur dernierSoigneurRecrute = (Soigneur) em.createQuery("select s from Soigneur s where s.dateRecrutement = (select max(s.dateRecrutement) from Soigneur s order by s.dateRecrutement desc)", Soigneur.class).getSingleResult();
			System.out.println(dernierSoigneurRecrute.getId());
			System.out.println(dernierSoigneurRecrute.getNom());
			System.out.println(dernierSoigneurRecrute.getNumero());
			System.out.println(dernierSoigneurRecrute.getDateRecrutement());
			
		} finally {
			em.close();
			emf.close();
		}
	}

}