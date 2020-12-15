package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Soigneur;
import com.animoz.repository.SoigneurRepository;

@Service
public class SoigneurService {
	
	@Autowired
	private SoigneurRepository soigneurRepository;

	public List<Soigneur> getListeSoigneurs() {
		return soigneurRepository.getListeSoigneurs();
	}

}
