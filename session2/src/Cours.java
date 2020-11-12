public class Cours extends ModuleFormation {
	private int numeroSalle;

	public Cours(int nbMaxStagiaires, int numeroSalle, String nom, int duree) {
		super(nom, duree);
		this.nbMaxStagiaires = nbMaxStagiaires;
		this.numeroSalle = numeroSalle;
	}
	
	public void setNumeroSalle(int numeroSalle) {
		this.numeroSalle = numeroSalle;
	}
	
	public int getNumeroSalle() {
		return this.numeroSalle;
	}
	
	public void setNbMaxStagiaires(int nbMaxStagiaires) {
		this.nbMaxStagiaires = nbMaxStagiaires;
	}
	
	public int getNbMaxStagiaires() {
		return this.nbMaxStagiaires;
	}
}
