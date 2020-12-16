package com.animoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.animoz.modele.Animal;
import com.animoz.service.AnimalService;

@Controller
public class ListeAnimalController {
	
	@Autowired
	private AnimalService animalService;

	@GetMapping("/animaux")
	public String afficherListeAnimaux(Model model) {
		List<Animal> animaux = animalService.getListeAnimaux();	
		model.addAttribute("listeAnimaux", animaux);
		return "listeAnimaux";
	}
	
	@RequestMapping("/animaux")
	public String afficherListeAnimauxRecherches(Model model, @RequestParam(name = "recherche") String recherche) {
		List<Animal> animaux = animalService.getListeAnimauxRecherches(recherche);
		model.addAttribute("listeAnimaux", animaux);
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
		
		System.out.println(animal.getNom());
		return "formulaireAnimal"; // test
	}

}
