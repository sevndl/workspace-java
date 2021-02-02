package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

public interface IClientRepository {
	
	Client getClientById(Long id);
	List<Client> getAllClients();
	void add(Client client);

}
