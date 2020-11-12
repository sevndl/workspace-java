import java.util.ArrayList;

public class Formation {
	private String nom;
	private ArrayList<ModuleFormation> listeModules = new ArrayList<ModuleFormation>();

  public Formation(String nom) {
		this.nom = nom;
	}

	public void ajouterModule(ModuleFormation module) {
		this.listeModules.add(module);
	}

  public int getDuree() {
		int dureeTotale = 0;

		// somme de la durée de chaque module
		for (ModuleFormation module : listeModules) {
			dureeTotale += module.getDuree();
		}
		return dureeTotale;
  }
  
  public int getNbMinStagiaires() {
		int nbMinStagiaires = Integer.MAX_VALUE;

		// comparer tous les nbMaxStagiaires et récupérer le plus petit
		for (ModuleFormation module : listeModules) {
			int nbMaxStagiairesCourant = module.getNbMaxStagiaires();  
			if ( nbMaxStagiairesCourant < nbMinStagiaires) {
				nbMinStagiaires = nbMaxStagiairesCourant;
			}
		}
		return nbMinStagiaires;
  }
}
