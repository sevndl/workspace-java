package fr.epsi.catalogue;

import fr.epsi.catalogue.NiveauPEGI.Niveaux;

public class JeuVideo extends Article {
	
	private Niveaux niveauPEGI;
	private String studioDeDeveloppement;

	public JeuVideo(String code, String titre, int noteMetascore, String studioDeDeveloppement, Niveaux niveauPEGI) {
		
		super.setCode(code);
		super.setTitre(titre);
		super.setNoteMetascore(noteMetascore);
		this.setNiveauPEGI(niveauPEGI);
		this.setStudioDeDeveloppement(studioDeDeveloppement);
		
	}

	public String getStudioDeDeveloppement() {
		return this.studioDeDeveloppement;
	}

	public void setStudioDeDeveloppement(String studioDeDeveloppement) {
		this.studioDeDeveloppement = studioDeDeveloppement;
	}

	public Niveaux getNiveauPEGI() {
		return this.niveauPEGI;
	}

	public void setNiveauPEGI(Niveaux niveauPEGI) {
		this.niveauPEGI = niveauPEGI;
	}

}
