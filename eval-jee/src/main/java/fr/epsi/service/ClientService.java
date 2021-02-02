package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;
import fr.epsi.repository.ClientRepository;
import fr.epsi.repository.IClientRepository;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientService implements IClientService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public Client getClientById(Long id) {
		IClientRepository dao = new ClientRepository(em, utx);
		return dao.getClientById(id);
	}
	
	public List<Client> getAllClients() {
		IClientRepository dao = new ClientRepository(em, utx);
		return dao.getAllClients();
	}
	
	public void add(Client client) {
		IClientRepository dao = new ClientRepository(em, utx);
		dao.add(client);
	}

	public Client getClientByFactureId(Long id) {
		IClientRepository dao = new ClientRepository(em, utx);
		return dao.getClientByFactureId(id);
	}

}
