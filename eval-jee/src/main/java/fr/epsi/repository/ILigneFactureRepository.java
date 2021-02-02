package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.LigneFacture;

public interface ILigneFactureRepository {
	
	List<LigneFacture> getLigneFactureByFactureId(Long id);
	void add(LigneFacture ligneFacture);

}
