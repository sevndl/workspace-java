package com.animoz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.service.AnimalService;

@Controller
public class ListeAnimalController {
	
	@Autowired
	private AnimalService animalService;

	@GetMapping("/animaux")
	public String afficherListeAnimaux(Model model, String recherche) {
		if (recherche == null || recherche == "") {
			model.addAttribute("listeAnimaux", animalService.getListeAnimaux());			
		} else {
			model.addAttribute("listeAnimaux", animalService.getListeAnimauxRecherches(recherche));
		}
		return "listeAnimaux";
	}
	
	@GetMapping("/animal")
	public String afficherFormulaireAnimal(@ModelAttribute("animal") AnimalDto animal) {
		return "formulaireAnimal";
	}
	
	@PostMapping("/animal")
	public String traiterFormulaireAnimal(@Validated @ModelAttribute("animal") AnimalDto animal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return afficherFormulaireAnimal(animal);
		}
		animalService.addAnimal(animal.getNom());
		System.out.println(animal.getNom());
		return "redirect:/animaux";
	}

}
