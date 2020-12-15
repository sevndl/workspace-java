package com.animoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.animoz.modele.Animal;
import com.animoz.modele.Soigneur;
import com.animoz.service.AnimalService;
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

}
