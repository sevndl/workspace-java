package com.animoz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListeAnimalController {

	@GetMapping(path = "/animaux") // anotation qui permet de dire que c'est une méthode HTTP GET
	public String afficherListeAnimaux(Model model) {
		model.addAttribute("leNombre", 42); // avec thymeleaf on peut dynamiser la page
		return "listeAnimaux"; // listeAnimaux est le nom de la vue, du template (la page html avec des instructions dynamiques)
	}

}
