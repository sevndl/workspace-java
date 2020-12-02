package fr.epsi.catalogue;

public class SerieTV extends Article {
	
	private String distributeur;
	private int nombreDeSaisons;

	public SerieTV(String distributeur, int nombreDeSaisons, String code, String titre, int noteMetascore) {
		
		super.setCode(code);
		super.setTitre(titre);
		super.setNoteMetascore(noteMetascore);
		this.setDistributeur(distributeur);
		this.setNombreDeSaisons(nombreDeSaisons);
		
	}

	public String getDistributeur() {
		return this.distributeur;
	}

	public void setDistributeur(String distributeur) {
		this.distributeur = distributeur;
	}

	public int getNombreDeSaisons() {
		return this.nombreDeSaisons;
	}

	public void setNombreDeSaisons(int nombreDeSaisons) {
		try {
			if (nombreDeSaisons < 0) {
				throw new IllegalArgumentException("Le nombre de saisons ne peut pas être négatif.");
			} else if (nombreDeSaisons == 0) {
				throw new IllegalArgumentException("Le nombre de saisons ne peut pas être nul.");
			}
			this.nombreDeSaisons = nombreDeSaisons;
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}			
	}

}
