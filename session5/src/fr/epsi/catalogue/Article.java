package fr.epsi.catalogue;

public abstract class Article {
	
	private String code;
	private String titre;
	private int noteMetascore;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNoteMetascore() {
		return this.noteMetascore;
	}

	public void setNoteMetascore(int noteMetascore) {
		
		try {
			if (noteMetascore < 0 || noteMetascore > 100) {
				throw new IllegalArgumentException("La note metascore est un nombre compris entre 0 et 100.");
			}
			this.noteMetascore = noteMetascore;
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
