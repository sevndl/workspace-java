package fr.epsi.service;

import javax.ejb.Stateless;

import fr.epsi.entite.Produit;

@Stateless
public class ProduitService implements IProduitService {

	public void createProduit(Produit p) {
		System.out.println(p.getNom());
		System.out.println(p.getCodeBarre());
	}

}
