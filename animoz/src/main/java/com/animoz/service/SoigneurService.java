package com.animoz.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.animoz.modele.Regime;
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

}
