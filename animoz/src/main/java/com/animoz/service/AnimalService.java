package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;
import com.animoz.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;

	public List<Animal> getListeAnimaux() {
		return animalRepository.getListeAnimaux();
	}
	
	public List<Animal> getListeAnimauxRecherches(String recherche) {
		return animalRepository.getListeAnimauxRecherches(recherche);
	}
	
	@Transactional
	public void addAnimal(String nomAnimal, String descriptionAnimal, Long especeAnimal, Regime regimeAlimentaireAnimal) {
		animalRepository.addAnimal(nomAnimal, descriptionAnimal, especeAnimal, regimeAlimentaireAnimal);
	}

	public Animal getById(Long idAnimal) {
		return animalRepository.getById(idAnimal);
	}
}
