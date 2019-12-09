package projetPOO01.AchatsCommande;

import projetPOO01.Controles.Controles;
import projetPOO01.GestionPersonnes.IClient;
import projetPOO01.GestionPersonnes.IFournisseur;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;
import projetPOO01.menu.AffichageListe;
import projetPOO01.menu.Creation;

public class NouvelAddition {
	static String num="";
	static int num1=0;
	static String dat="";
	static String descr="";
	static String qt = "";
	
	public static void registrClient()
	{
		for (Personne c:Creation.lc)
		{
			if (c instanceof IClient)
			{
				AffichageListe.ic.add((IClient) c);
			}
		}
	}
	public static void registrFour()
	{
		for (Personne c:Creation.lc)
		{
			if (c instanceof IFournisseur)
			{
				AffichageListe.iff.add((IFournisseur) c);
			}
		}
	}
	
	public static void newAdd(String type)
	{
		
		if (type.equals("Client"))
		{
			NouvelAddition.registrClient();
			System.out.println("Quel client souhaite faire des achats");
			NouvelAddition.newAddition();
			Achat monAchat = new Achat (dat, descr, qt);
			AffichageListe.la.add(monAchat);
			AffichageListe.ic.get(num1).achete(AffichageListe.la);
			AffichageListe.ic.get(num1).paie();
			AffichageListe.la.stream().forEach(System.out::println);	

		}
		if (type.equals("Fournisseur"))
		{
			NouvelAddition.registrFour();
			System.out.println("Quel fournisseur souhaite faire une commande");
			NouvelAddition.newAddition();
			Commande maCommande= new Commande (dat, descr, qt);
			AffichageListe.lco.add(maCommande);
			AffichageListe.iff.get(num1).commander(AffichageListe.lco);
			AffichageListe.iff.get(num1).livrer();
			AffichageListe.lco.stream().forEach(System.out::println);	
		}
	}
	public static void newAddition()
	{
		boolean ok=false;
		boolean reussi = false;
		while (ok==false)
		{
			
		
		while(reussi==false)
		{
				 num = Creation.s1.nextLine();	
			try {
		
				Controles.ctrlInt(num);
				 num1 = Integer.parseInt(num)-1;
				
				reussi=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
			reussi=false;
			System.out.println("erreur de saisie");
			}
		}
		
		reussi=false;
		while(reussi==false)
		{
		System.out.println("Date de l'achat");
		 dat = Creation.s1.nextLine();
		 try {
			 Controles.ctrlDate(dat);
			reussi=true;
		} catch (ErreurSaisie e2) {
			// TODO Auto-generated catch block
			reussi=false;
			System.out.println("erreur de saisie sur ladate");
		}
		 
		}
		System.out.println("Description de l'achat");
		 descr = Creation.s1.nextLine();
		

		 reussi = false;
		while(reussi==false)
		{
			System.out.println("Quantité demandée");
			 qt = Creation.s1.nextLine();
			

			try {
		
				Controles.ctrlInt(qt);
				reussi=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					throw new Exception("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}	

			reussi=false;
			System.out.println("erreur de saisie");
			}
		}
		
		System.out.println("Souhaitez repeter l'opération: tapez non si vous ne voulez pas");
		String rep = Creation.s1.nextLine();
		
			if (rep.equals("non"))
			{
				ok=true;
			}
		
		
		}
	}
}

