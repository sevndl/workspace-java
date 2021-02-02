package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.Client;

public interface IClientRepository {
	
	List<Client> getAllClients();
	void add(Client client);

}
