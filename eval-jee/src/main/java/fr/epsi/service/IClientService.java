package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

public interface IClientService {
	
	List<Client> getAllClients();
	Client getClientById(Long id);
	void add(Client client);

}
