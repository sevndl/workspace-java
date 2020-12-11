package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Animal;
import com.animoz.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;

	public List<Animal> getListeAnimaux() {
		return animalRepository.getListeAnimaux();
	}

}
