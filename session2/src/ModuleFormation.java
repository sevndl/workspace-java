public abstract class ModuleFormation {
  private String nom;
  private String description = "";
  protected int nbMaxStagiaires = 0;
  private int duree = 0;

  public ModuleFormation(String nom, int duree) {
    this.nom = nom;
    this.duree = duree;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setDuree(int duree) {
    this.duree = duree;
  }

  public String getNom() {
    return this.nom;
  }

  public int getDuree() {
    return this.duree;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public int getNbMaxStagiaires() {
    return this.nbMaxStagiaires;
  }
}
