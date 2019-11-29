package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;

public class Salarie extends Personne implements IClient {

	private String numSecu;
	private String salaire;
	private boolean estClient;


	public Salarie(String nom, String prenom, String adresse, String ville, String codePostal, String numSecu,
			String salaire, boolean estClient) {
		super(nom, prenom, adresse, ville, codePostal);
		this.numSecu = numSecu;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}

	



	@Override
	public void paie() {
		// TODO Auto-generated method stub

	}

	public String getNumSecu() {
		return numSecu;
	}

	public String getSalaire() {
		return salaire;
	}

	@Override
	public String toString() {
		return "Salarie [numSecu=" + numSecu + ", salaire=" + salaire + ", toString()=" + super.toString() + "]";
	}





	@Override
	public void achete(List<Achat> achat) {
		// TODO Auto-generated method stub
		
	}

	public static void UniqueSecu(String ns, List<Personne> lc) throws ErreurSaisie
	{
		for(Personne c: lc)
		{
		
			if (c instanceof Salarie)
			{
				if (ns.equals(((Salarie)c).getNumSecu())) throw new ErreurSaisie("Ce numéro existe déja");
			}
			
		}
	}



	@Override
	public boolean estClient() {
		
		return this.estClient;
	}



}
