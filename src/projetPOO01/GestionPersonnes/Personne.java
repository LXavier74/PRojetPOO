package projetPOO01.GestionPersonnes;

public class Personne {

	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codePostal;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
/*
	public Personne() {
		// TODO Auto-generated constructor stub
		 this.adresse="";
		this.codePostal="";
		this.nom="";
		this.prenom="";
		this.ville="";
		this.codePostal=""; 
		this("","","","","");
	}
*/
	public Personne(String nom, String prenom, String adresse, String ville, String codePostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
	
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ville=" + ville
				+ ", codePostal=" + codePostal + "]";
	}



}
