package projetPOO01.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import projetPOO01.GestionPersonnes.IClient;
import projetPOO01.GestionPersonnes.IFournisseur;
import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;

public class AffichageSelection {
	private static String choix = null;

	public static void debut(){

		
			Map<String, IExecute> im1 = new HashMap<String,IExecute>();

			/*
			im1.put("0 pour créer des données",AffichageMenu::menuCreation);
			im1.put("1 pour afficher des données",Creation::creerClient);
*/
			
			im1.put("0 pour créer un client",Creation::creerClient);
			im1.put("1 pour créer un fournisseur",Creation::creerFournisseur);
			im1.put("2 pour créer un salarié",Creation::creerSalarie);
			im1.put("3 pour une liste des clients",()->AffichageListe.listeGenerale(Creation.lc.stream().filter(item -> item instanceof IClient), "Clients"));
			im1.put("4 pour une liste des fournisseurs",()->AffichageListe.listeGenerale(Creation.lc.stream().filter(item -> item instanceof IFournisseur), "Fournisseurs"));
			im1.put("5 pour une liste des salariés",()->AffichageListe.listeGenerale(Creation.lc.stream().filter(item -> item instanceof Salarie), "Salaries"));
			im1.put("6 pour une liste des générale",()->AffichageListe.listeGenerale(Creation.lc.stream().filter(item -> item instanceof Personne), "tout le monde"));
			im1.put("7 pour créer un patron",Creation::creerPatron);
			im1.put("8 pour voir le patron",()->AffichageListe.listeGenerale(Creation.lc.stream().filter(item -> item instanceof Patron), "sur le patron"));
			im1.put("9 pour quitter",AffichageSelection::quitter);

			
			im1.keySet().stream().sorted().forEach(System.out::println);
			
			while(true) {
			
			choix = Creation.s1.next();
			
			im1.entrySet().stream().filter(e->e.getKey().charAt(0) == choix.charAt(0)).
			forEach(e->e.getValue().apply());
						
			}
		
	}
	public static void quitter()
	{
		System.out.println("Au revoir");
		System.exit(0);
	}
}
