package projetPOO01.GestionPersonnes;import java.util.List;

import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;


public class Client extends Personne implements IFournisseur, IClient {
	
 private String numClient;
 private boolean estClient=true;
 private boolean estFournisseur;
 	
	public Client(String nom, String prenom, String adresse, String ville, String codePostal,String numClient, boolean estFournisseur) {
		super(nom, prenom, adresse, ville, codePostal);
		this.numClient = numClient;
		this.estFournisseur = estFournisseur;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void livrer() {
		// TODO Auto-generated method stub
		System.out.println("Livraison client OK");
	}




	@Override
	public void paie() {
		// TODO Auto-generated method stub
		System.out.println("Client paie");
	}

	public String getNumClient() {
		return numClient;
	}





	@Override
	public String toString() {
		return "Client [numClient=" + numClient + ", estClient=" + estClient + ", estFournisseur=" + estFournisseur
				+ ", toString()=" + super.toString() + "]";
	}


	public static void UniqueCli(String nc, List<Personne> lc) throws ErreurSaisie
	{
		for(Personne c: lc)
		{
		
			if (c instanceof Client)
			{
				if (nc.equals(((Client)c).getNumClient())) throw new ErreurSaisie("Ce numéro existe déja");
			}
			
		}
	}

	@Override
	public boolean estClient() {
		return this.estClient;
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


	@Override
	public void achete(List<Achat> achat) {
		// TODO Auto-generated method stub
	
	}		
	


}
