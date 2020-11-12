public class Tutoriel extends ModuleFormation {
	private String lienVideo;
	
	public Tutoriel(String lienVideo, String nom, int duree) {
		super(nom, duree);
		this.nbMaxStagiaires = Integer.MAX_VALUE;
		this.lienVideo = lienVideo;
	}

	public void setLienVideo(String lienVideo) {
		this.lienVideo = lienVideo;
	}
	
	public String getLienVideo() {
		return this.lienVideo;
	}
	
	public void setNbMaxStagiaires(int nbMaxStagiaires) {
		this.nbMaxStagiaires = nbMaxStagiaires;
	}
	
	public int getNbMaxStagiaires() {
		return this.nbMaxStagiaires;
	}
}
