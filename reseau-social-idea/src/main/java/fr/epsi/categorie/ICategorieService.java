package fr.epsi.categorie;

import java.util.List;

public interface ICategorieService {
	
	void add(Categorie c);
	List<Categorie> get();
	Categorie getById(Long id);

}
