package fr.epsi.classement;

import java.util.List;

import fr.epsi.idee.Idee;

public interface IClassementDao {
	
	List<Idee> getTop3IdeesPlusDeVotes();

}
