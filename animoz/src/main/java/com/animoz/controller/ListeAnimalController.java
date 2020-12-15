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
	
	@GetMapping("/animal")
	// demande à Spring un param de type AnimalDto -> @ModelAttribute c'est un truc qui doit être dans le model, s'il n'y est pas crée-le
	public String afficherFormulaireAnimal(@ModelAttribute("animal") AnimalDto animal) {
//		animal.setNom("sev"); // on peut ainsi pré-remplir le formulaire
		return "formulaireAnimal";
	}
	
	@PostMapping("/animal")
	public String traiterFormulaireAnimal(@Validated @ModelAttribute("animal") AnimalDto animal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return afficherFormulaireAnimal(animal);
		}
		// TODO traiter le formulaire => appeler le service pour 
//		return "succesCreationAnimal"; // à créer
		
		System.out.println(animal.getNom());
		return "formulaireAnimal"; // test
	}

}
