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

import com.animoz.modele.Soigneur;
import com.animoz.service.SoigneurService;

@Controller
public class ListeSoigneurController {
	
	@Autowired
	private SoigneurService soigneurService;
	
	@GetMapping("/soigneurs")
	public String afficherListeSoigneurs(Model model) {
		List<Soigneur> soigneurs = soigneurService.getListeSoigneurs();
		model.addAttribute("listeSoigneurs", soigneurs);
		return "listeSoigneurs";
	}
	
	@GetMapping("/soigneur")
	public String afficherFormulaireSoigneur(@ModelAttribute("soigneur") SoigneurDto soigneur) {
		return "formulaireSoigneur";
	}
	
	@PostMapping("/soigneur")
	public String traiterFormulaireSoigneur(@Validated @ModelAttribute("soigneur") SoigneurDto soigneur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return afficherFormulaireSoigneur(soigneur);
		}
		soigneurService.addSoigneur(soigneur.getNom(), soigneur.getNumero(), soigneur.getDateRecrutement());
		return "redirect:/soigneurs";
	}

}
