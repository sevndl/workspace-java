package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Client;

public interface IClientService {
	
	List<Client> getAllClients();
	void add(Client client);

}
