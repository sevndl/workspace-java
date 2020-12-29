package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Espece;
import com.animoz.repository.EspeceRepository;

@Service
public class EspeceService {
	
	@Autowired
	private EspeceRepository especeRepository;

	public List<Espece> getListeEspeces() {
		return especeRepository.getListeEspeces();
	}

}
