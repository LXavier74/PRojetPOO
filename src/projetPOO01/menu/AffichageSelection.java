package projetPOO01.menu;

public class AffichageSelection {

	public static void debut(){
		boolean arret=false;

		while (arret==false)
			
		{
		System.out.println("1 = client , 2 = fournisseur, 3 = salarie, 4 = liste client, 5 = liste fournisseur, 6 = liste salarie, 7 = liste générale");


		System.out.println("Que voulez vous ajouter ?");
		String choix = Creation.s1.nextLine();
		switch (choix) {
		  case "1":
			  Creation.creerClient();
				break;
		  case "2":
			  Creation.creerFournisseur();
				  break;
		  case "3": 
			Creation.creerSalarie();
				  break;
		  case "4":
			AffichageListe.listeClients();
				  break;
		  case "5":
			  AffichageListe.listeFournisseurs();
				  break;
		  case "6":
			  AffichageListe.listeSalaries();
				  break;
		  case "7":
				AffichageListe.listeGenerale();
				  break;
		  case "8":
				Creation.creerPatron();
				  break;
		  case "9":
				AffichageListe.patron();
				  break;
		  default:
				System.out.println("Vous avez fait une erreur");
				break;
		}
		System.out.println("Vous voulez arrêter");	
		
		String arr = Creation.s1.nextLine();
		
		if(arr.equals("oui"))
		{
			arret=true;
		}
		
		
		}
		
		System.out.println("ARRET");
	}
}
