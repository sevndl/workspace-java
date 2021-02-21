package fr.epsi.idee;

import java.util.List;

public interface IIdeeService {
	
	void add(Idee i);
	List<Idee> get();
	Idee getById(Long id);
	void addTopById(Long id);
	void addFlopById(Long id);

}
