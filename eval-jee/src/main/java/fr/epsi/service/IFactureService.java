package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Facture;

public interface IFactureService {
	
	List<Facture> getAllFactures();
	List<Facture> getFactureByClientId(Long id);
	Facture getFactureById(Long id);
	void add(Facture facture);

}
