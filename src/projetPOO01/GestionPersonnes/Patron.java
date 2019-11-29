package projetPOO01.GestionPersonnes;

import java.util.List;


public class Patron extends Salarie implements IPatron {

	public Patron(String nom, String prenom, String adresse, String ville, String codePostal, String numSecu,
			String salaire, boolean estClient) {
		super(nom, prenom, adresse, ville, codePostal, numSecu, salaire, estClient);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void embauche() {
		// TODO Auto-generated method stub

	}

	@Override
	public void licenciement() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void paieSalarie() {
		// TODO Auto-generated method stub
		System.out.println("PAIEMENT OK");

	}

	public static void  PatronExiste(List<Personne> lc)
	{
		for(Personne c: lc)
		{
		
			if (lc.contains(c))
			{
			lc.remove(c);
			return;
			}
			
		}
	}

	@Override
	public String toString() {
		return "Patron [toString()=" + super.toString() + "]";
	}







	
}
