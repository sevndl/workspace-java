package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.animoz.modele.Soigneur;
import com.animoz.repository.SoigneurRepository;

@Service
public class SoigneurService {
	
	@Autowired
	private SoigneurRepository soigneurRepository;

	public List<Soigneur> getListeSoigneurs() {
		return soigneurRepository.getListeSoigneurs();
	}
	
	@Transactional
	public void addSoigneur(String nomSoigneur, String numeroSoigneur, String dateRecrutement) {
		soigneurRepository.addSoigneur(nomSoigneur, numeroSoigneur, dateRecrutement);
	}

	public List<Soigneur> getByAnimalId(Long idAnimal) {
		return soigneurRepository.getByAnimalId(idAnimal);
	}

	@Transactional
	public void removeSoigneur(Long idAnimal, Long idSoigneur) {
		soigneurRepository.removeSoigneur(idAnimal, idSoigneur);
	}
}
