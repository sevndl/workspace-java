package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.animoz.modele.Animal;

@Repository
public class AnimalRepository {

	@Autowired
	private EntityManager em;
	
	public List<Animal> getListeAnimaux() {
		return em.createQuery("select a from Animal a order by a.nom asc", Animal.class)
				 .getResultList();
	}
	
	public List<Animal> getListeAnimauxRecherches(String recherche) {
		return em.createQuery("select a from Animal a where lower(a.nom) like concat('%',:nom,'%')", Animal.class)
//		return em.createQuery("select a from Animal a where lower(a.nom) = lower(:nom)", Animal.class)				
				 .setParameter("nom", recherche)
				 .getResultList();
	}
	
	public void addAnimal(String nomAnimal) {
		Animal newAnimal = new Animal();
		newAnimal.setNom(nomAnimal);
		em.persist(newAnimal);
	}

}
