package projetPOO01.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projetPOO01.Programme;
import projetPOO01.AchatsCommande.NouvelAddition;
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
	public static List<Achat> la = new ArrayList<Achat>();
	public static List <IFournisseur> iff= new ArrayList();;
	public	static List<Commande> lco = new ArrayList<Commande>();

	
	public static void listeGenerale() {
		System.out.println("Vous voulez une liste générale");
		
		for(Personne c:Creation.lc)
		{
		
			System.out.println(c);
		
		}		
	}

	public static void listeClients()
	{
		System.out.println("Vous voulez la liste des clients");
		int compteur=0;
		int num1=0;
		
		for(Personne c:Creation.lc)
		{
			if (c instanceof IClient && ((IClient) c).estClient()==true)
			{
				compteur++;
			System.out.println(c + "n° " + compteur);
			ic.add((IClient) c);
			}
		}
		NouvelAddition.newAchat();
		
		

	}
	
	public static void listeFournisseurs()
	{
		System.out.println("Vous voulez la liste des fournisseurs");
		int compteur=0;

		for(Personne c:Creation.lc)
		{
			if (c instanceof IFournisseur && ((IFournisseur) c).estFournisseur()==true)
			{
			System.out.println(c+ "n° " + compteur);
			iff.add((IFournisseur) c);
			}
		}
		NouvelAddition.newCommande();
		
		
	}
	public static void patron()
	{
		
		for(Personne c:Creation.lc)
		{
			if (c instanceof Patron)
			{
			System.out.println(c);
			}
		}
	}
	public static void listeSalaries()
	{
		System.out.println("Vous voulez la liste des salariés");
		
		for(Personne c:Creation.lc)
		{
			if (c instanceof Salarie)
			{
			System.out.println(c);
			}
		}
	}
}
