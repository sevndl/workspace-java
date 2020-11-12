public class Projet extends ModuleFormation {
	private int nbGroupes;
	private int nbStagiairesGroupe;

	public Projet (int nbGroupes, int nbStagiairesGroupe, String nom, int duree) {
		super(nom, duree);
		this.nbGroupes = nbGroupes;
		this.nbStagiairesGroupe = nbStagiairesGroupe;
		this.nbMaxStagiaires = this.nbGroupes * this.nbStagiairesGroupe;
	}

	public void setNbGroupes(int nbGroupes) {
		this.nbGroupes = nbGroupes;
	}
	
	public void setNbStagiairesGroupe(int nbStagiairesGroupe) {
		this.nbStagiairesGroupe = nbStagiairesGroupe;
	}

	public int getNbMaxStagiaires() {
		return this.nbGroupes * this.nbStagiairesGroupe;
	}
	
	// public int getNbGroupes() {
	// 	return this.nbGroupes;
	// }
	
	// public int getNbStagiairesGroupe() {
	// 	return this.nbStagiairesGroupe;
	// }

}
