package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;

/**
 * 
 * @author Xavier LA
 * @version 1.0
 * <b> Javadoc pour la POE de Lyon </b>
 *
 */
public class Personne {

	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codePostal;
	
	
	/**
	 * Accesseur de nom
	 * @return nom de la personne
	 */
	public String getNom() {
		return nom;
	}

/**
 * Mutateur de nom
 * @param nom : nouveau nom de la personne
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Accesseur de prénom
	 * @return prénom de la personne
	 */
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

	/**
	 * 
	 * @param nom : nom de la personne
	 * @param prenom : prénom de la personne
	 * @param adresse : adresse de la personne
	 * @param ville : ville dans laquelle la personne habite
	 * @param codePostal : code postal de la personne
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
	
	
	public static void testCP(String cp) throws ErreurSaisie
	{
		
			if (cp.length()!=5)
			{
				throw new ErreurSaisie("Il faut 5 caractères");
			}
			if (!cp.matches("\\d{1,9}"))
			{
				throw new ErreurSaisie("Il ne faut que des chiffres");
			}
			
			
		
	}

}
