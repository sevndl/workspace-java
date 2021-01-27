package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IProduitDao;
import fr.epsi.dao.ProduitDao;
import fr.epsi.entite.Produit;

//CONTAINER -> transactions par le serveur d'application => pas utile ici
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProduitService implements IProduitService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public void createProduit(Produit p) {
		IProduitDao dao = new ProduitDao(em, utx);
		dao.create(p);
	}

}
