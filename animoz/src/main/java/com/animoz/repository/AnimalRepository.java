package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;

@Repository
public class AnimalRepository {

	@Autowired
	private EntityManager em;
	
	public List<Animal> getListeAnimaux() {
		return em.createQuery("select a from Animal a order by a.nom asc", Animal.class)
				 .getResultList();
	}
	
	public List<Animal> getListeAnimauxRecherches(String recherche) {
		return em.createQuery("select a from Animal a where lower(a.nom) like concat('%',:nom,'%') order by a.nom asc", Animal.class)	
				 .setParameter("nom", recherche)
				 .getResultList();
	}
	
	public void addAnimal(String nomAnimal, String descriptionAnimal, Long especeIdAnimal, Regime regimeAlimentaireAnimal) {
		Long verificationAnimalExiste = (Long) em.createQuery("select count(a) from Animal a where a.nom = :nom")
				.setParameter("nom", nomAnimal)
				.getSingleResult();
		if (verificationAnimalExiste < 1) {
			Animal newAnimal = new Animal();
			newAnimal.setNom(nomAnimal);
			if (descriptionAnimal != "") { newAnimal.setDescription(descriptionAnimal); }
			if (especeIdAnimal != null) { 
				Espece espece = em.createQuery("select e from Espece e where e.id = :id", Espece.class)
						.setParameter("id", especeIdAnimal)
						.getSingleResult();
				Espece especeId = em.getReference(Espece.class, espece.getId());
				newAnimal.setEspece(especeId); 
			}
			if (regimeAlimentaireAnimal != null) { newAnimal.setRegime(regimeAlimentaireAnimal); }
			em.persist(newAnimal);
		}
	}
	
	public Animal getById(Long idAnimal) {
		return em.createQuery("select a from Animal a where a.id = :id", Animal.class)
				 .setParameter("id", idAnimal)
				 .getSingleResult();
	}

}
