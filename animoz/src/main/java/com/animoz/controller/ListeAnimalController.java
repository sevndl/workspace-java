package com.animoz.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ListeAnimalController {

	public String afficherListeAnimaux() {
		return "listeAnimaux";
	}

}
