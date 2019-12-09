package projetPOO01.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import projetPOO01.Programme;
import projetPOO01.AchatsCommande.NouvelAddition;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.IClient;
import projetPOO01.GestionPersonnes.IFournisseur;
import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;

public class AffichageListe {
	public static List <IClient> ic = new ArrayList();
	public final static List<Achat> la = new ArrayList<Achat>();
	public static List <IFournisseur> iff= new ArrayList();;
	public	static List<Commande> lco = new ArrayList<Commande>();

	
	public static void listeGenerale(Stream <? extends Personne> lp, String n) {
		System.out.println("Vous voulez une liste de "+n);
		Creation.lc.forEach(System.out::println);
		
		if (n.equals("Clients"))
		{
		System.out.println("un client veut il faire des achats");
		Creation.s1.nextLine();
		String choix = Creation.s1.nextLine();
		
			if (choix.equals("oui"))
			{
				NouvelAddition.newAdd("Client");
			}
		}
		
		if (n.equals("Fournisseurs"))
		{
		System.out.println("un fournisseur veut il faire des achats");
		Creation.s1.nextLine();
		String choix = Creation.s1.nextLine();
		
			if (choix.equals("oui"))
			{
				NouvelAddition.newAdd("Fournisseur");
			}
		}
		AffichageSelection.debut();
	}


}
