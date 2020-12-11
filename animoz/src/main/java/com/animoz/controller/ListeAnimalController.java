package com.animoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.animoz.modele.Animal;
import com.animoz.service.AnimalService;

@Controller
public class ListeAnimalController {
	
	@Autowired
	private AnimalService animalService;

	@GetMapping("/animaux")
	public String afficherListeAnimaux(Model model) {
		model.addAttribute("leNombre", 42);
		List<Animal> animaux = animalService.getListeAnimaux();
		model.addAttribute("listeAnimaux", animaux);
		return "listeAnimaux";
	}

}
