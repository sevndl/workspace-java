package fr.epsi.classement;

import java.util.List;

import fr.epsi.idee.Idee;

public interface IClassementService {

	public List<Idee> getTop3IdeesPlusDeVotes();
	
}
