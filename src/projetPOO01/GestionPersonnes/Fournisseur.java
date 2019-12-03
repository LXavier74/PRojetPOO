package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;

public class Fournisseur extends Personne implements IClient, IFournisseur {
private String numFournisseur;
private boolean estClient;
private boolean estFournisseur=true;
private List<Achat> listeAchat;
private List <Commande> listeCommande;

	public List<Commande> getListeCommande() {
	return listeCommande;
}



	public Fournisseur(String nom, String prenom, String adresse, String ville, String codePostal, String numFournisseur, boolean estClient) {
		super(nom, prenom, adresse, ville, codePostal);
		this.numFournisseur= numFournisseur;
		this.estClient = estClient;

		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Fournisseur [numFournisseur=" + numFournisseur + ", estClient=" + estClient + ", estFournisseur="
				+ estFournisseur + ", listeAchat=" + listeAchat + ", toString()=" + super.toString() + "]";
	}



	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Fournisseur paie");
	}

	@Override
	public void livrer() {
		// TODO Auto-generated method stub
		System.out.println("Livraison fournisseur OK");
	}



	public String getNumFournisseur() {
		return numFournisseur;
	}

	@Override
	public boolean estClient() {
	
		return this.estClient;
	}


	public static void UniqueFour(String nf, List<Personne> lc) throws ErreurSaisie
	{
		for(Personne c: lc)
		{
		
			if (c instanceof Fournisseur)
			{
				if (nf.equals(((Fournisseur)c).getNumFournisseur())) throw new ErreurSaisie("Ce numéro existe déja");
			}
			
		}
	}

	@Override
	public void achete(List<Achat> achat) {
		// TODO Auto-generated method stub
		listeAchat = achat;	
	}



	@Override
	public void commander(List<Commande> achat) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean estFournisseur() {
		// TODO Auto-generated method stub
		return this.estFournisseur;
	}



	public List<Achat> getListeAchat() {
		return listeAchat;
	}






}
