package fr.epsi.idee;

import java.util.List;

public interface IIdeeDao {
	
	void add(Idee u);
	List<Idee> get();
	Idee getById(Long id);
	void addTopById(Long id);
	void addFlopById(Long id);

}
