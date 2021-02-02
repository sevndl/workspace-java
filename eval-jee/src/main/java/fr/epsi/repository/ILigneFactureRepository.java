package fr.epsi.repository;

import fr.epsi.entite.LigneFacture;

public interface ILigneFactureRepository {
	
	LigneFacture getLigneFactureByFactureId(Long id);
	void add(LigneFacture ligneFacture);

}
