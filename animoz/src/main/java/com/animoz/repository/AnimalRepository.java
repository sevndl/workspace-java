package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;

@Repository
public class AnimalRepository {

	@Autowired
	private EntityManager em; // Spring fait tout pour nous (ouvrir, fermer, etc)
	
	public List<Animal> getListeAnimaux() {
		return em.createQuery("select a from Animal a", Animal.class)
				 .getResultList();
	}

}