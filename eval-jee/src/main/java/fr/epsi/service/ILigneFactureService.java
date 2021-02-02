package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.LigneFacture;

public interface ILigneFactureService {
	
	void add(LigneFacture ligneFacture);
	List<LigneFacture> getLigneFactureByFactureId(Long id);

}
