package fr.epsi.service;

import fr.epsi.entite.LigneFacture;

public interface ILigneFactureService {
	
	void add(LigneFacture ligneFacture);
	LigneFacture getLigneFactureByFactureId(Long id);

}
