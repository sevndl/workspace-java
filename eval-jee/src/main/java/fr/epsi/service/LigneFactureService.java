package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.entite.LigneFacture;
import fr.epsi.repository.ILigneFactureRepository;
import fr.epsi.repository.LigneFactureRepository;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class LigneFactureService implements ILigneFactureService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public void add(LigneFacture ligneFacture) {
		ILigneFactureRepository dao = new LigneFactureRepository(em, utx);
		dao.add(ligneFacture);
	}	

}
