package com.animoz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.modele.Animal;
import com.animoz.service.AnimalService;
import com.animoz.service.EspeceService;
import com.animoz.service.SoigneurService;

@Controller
public class ListeAnimalController {
	
	@Autowired
	private AnimalService animalService;
	@Autowired
	private EspeceService especeService;
	@Autowired
	private SoigneurService soigneurService;

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
	public String afficherFormulaireAnimal(@ModelAttribute("animal") AnimalDto animal, Model model) {
		model.addAttribute("listeEspeces", especeService.getListeEspeces());
		return "formulaireAnimal";
	}
	
	@GetMapping("/animal/{idAnimal}")
	public String afficherDetailAnimal(@PathVariable Long idAnimal, Model model) {
		model.addAttribute("animal", animalService.getById(idAnimal));
		model.addAttribute("soigneurs", soigneurService.getByAnimalId(idAnimal));
		return "detailAnimal";
	}
	
	@PostMapping("/animal")
	public String traiterFormulaireAnimal(@Validated @ModelAttribute("animal") AnimalDto animal, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return afficherFormulaireAnimal(animal, model);
		}
		animalService.addAnimal(animal.getNom(), animal.getDescription(), animal.getEspece(), animal.getRegimeAlimentaire());
		return "redirect:/animaux";
	}

}
