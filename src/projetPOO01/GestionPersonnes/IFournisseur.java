package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.GestionsCommandes.Commande;

public interface IFournisseur {

	public void livrer();
	public void commander(List<Commande> achat);
	public boolean estFournisseur();
	
}
