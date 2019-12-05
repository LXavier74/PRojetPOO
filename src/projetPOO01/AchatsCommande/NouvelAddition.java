package projetPOO01.AchatsCommande;

import projetPOO01.Programme;
import projetPOO01.Controles.Controles;
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
	
	public static void newAchat()
	{
		boolean ok=false;
		boolean reussi = false;
		while (ok==false)
		{
			
		
		while(reussi==false)
		{
			System.out.println("Quel client souhaite faire des achats");
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
		Achat monAchat = new Achat (dat, descr, qt);
		AffichageListe.la.add(monAchat);

		System.out.println("Souhaitez vous faire un autre achat: tapez non si vous ne voulez pas");
		String rep = Creation.s1.nextLine();
		{
			if (rep.equals("non"))
			{
				ok=true;
			}
		
		}
		}
		
	
			
		
		
		AffichageListe.ic.get(num1).achete(AffichageListe.la);
		AffichageListe.ic.get(num1).paie();
		for(Achat a:AffichageListe.la)
		{
			System.out.println(a);
		}
	}
	
	public static void newCommande()
	{
		int num1=0;
		String num="";
		String dat="";
		String descr="";
		String qt = "";
		
		boolean ok=false;
		boolean reussi = false;
		while (ok==false)
		{
			
		
		while(reussi==false)
		{
			System.out.println("Quel fournisseur souhaite commander");
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
		System.out.println("Date de la commande");
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
		System.out.println("Description de la commande");
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
		Commande maCommande= new Commande (dat, descr, qt);
		AffichageListe.lco.add(maCommande);

		System.out.println("Souhaitez vous faire un autre commande: tapez non si vous ne voulez pas");
		String rep = Creation.s1.nextLine();
		{
			if (rep.equals("non"))
			{
				ok=true;
			}
		
		}
		}
		
		
		AffichageListe.iff.get(num1).commander(AffichageListe.lco);
		AffichageListe.iff.get(num1).livrer();
		for(Commande c:AffichageListe.lco)
		{
			System.out.println(c);
		}
		
	}
}
