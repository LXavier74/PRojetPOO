package projetPOO01.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projetPOO01.Programme;
import projetPOO01.Controles.Controles;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.GestionPersonnes.IClient;
import projetPOO01.GestionPersonnes.IFournisseur;
import projetPOO01.GestionPersonnes.IPatron;
import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;

public class Creation {
	public static Scanner s1= new Scanner(System.in);
	static String nom="";
	static String prenom="";
	static String adresse="";
	static String ville ="";
	static String cp ="";
	public static List<Personne> lc = new ArrayList<Personne>();
	public static List <IFournisseur> iff= new ArrayList();;
	public	static List<Commande> lco = new ArrayList<Commande>();

	
	
	
	
	public static void afficheGeneral()
	{
		System.out.println("Quel est votre nom ?");
		 nom = s1.nextLine();
		System.out.println("Quel est votre prénom ?");
		 prenom = s1.nextLine();
		System.out.println("Quel est votre adresse ?");
		 adresse = s1.nextLine();
		System.out.println("Quel est votre ville ?");
		 ville = s1.nextLine();
		
		boolean reussi = false;
		 cp ="";
		while(reussi==false)
		{
		System.out.println("Quel est votre code postal ?");
		cp = s1.nextLine();
		try {
			Client.testCP(cp);
			reussi=true;
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			System.out.println("erreur de saisie");
		}
		}
		
	}
	
	
	public static void creerClient()
	{
		Creation.afficheGeneral();
		String numCli = "";
		boolean reussi;
		reussi=false;
		while(reussi==false)
		{
			System.out.println("Quel est votre numero client ?");

			numCli = s1.nextLine();
	
			
				try {
					Client.UniqueCli(numCli, lc);
					try {
						Controles.ctrlInt(numCli);
						reussi=true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Il faut des nombres");

					}
				} catch (ErreurSaisie e) {
					// TODO Auto-generated catch block
					System.out.println("Ce numéro existe déja");
					
				}
		}
		System.out.println("Etes vous un fournisseur true/false ?");
		Boolean estFournisseur = s1.nextBoolean();
		s1.nextLine();

		Personne monCli= new Client(nom, prenom , adresse,ville,cp,numCli, estFournisseur);
		System.out.println(monCli.toString());
		lc.add(monCli);
		
		}
	
	
	public static void creerFournisseur()
	{
		Creation.afficheGeneral();
		System.out.println("Quel est votre numero fournisseur ?");
		String numFour = "";

		
		boolean reussi = false;
		while(reussi==false)
		{
		do {
			numFour = s1.nextLine();
			if (!numFour.matches("\\d{1,9}")) {
				System.out.println("Rentrez un format correct");
			}
			else {
				try {
					Fournisseur.UniqueFour(numFour,lc);
					reussi=true;
				} catch (ErreurSaisie e) {
					// TODO Auto-generated catch block
					System.out.println("Ce numéro existe déja");
					
				}
			}
		}
			while (!numFour.matches("\\d{1,9}") && reussi==false);
		}
		System.out.println("Etes vous un clietn true/false ?");
		Boolean estClient = s1.nextBoolean();
		s1.nextLine();
		Personne monFour= new Fournisseur(nom, prenom , adresse,ville,cp,numFour, estClient);
		System.out.println(monFour.toString());
		
	lc.add(monFour);
	}
	
	public static void creerSalarie()
	{

		Creation.afficheGeneral();
		String numSecu="";

		boolean reussi = false;
		while(reussi==false)
		{
			System.out.println("Quel est votre numero de secu ?");
			numSecu = s1.nextLine();
		
			
				try {
					Salarie.UniqueSecu(numSecu, lc);
					Salarie.SecuNombre(numSecu);
					Salarie.SecuNombreFormat(numSecu);
					reussi=true;
				} catch (ErreurSaisie e) {
					// TODO Auto-generated catch block
					System.out.println("Vous avez fait une erreur de saisie ou ce numéro existe déja");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Vous avez fait une erreur de saisie ou ce numéro existe déja");
				}
			
		
		}
		System.out.println("Quel est votre salaire ?");
		String salaire;
		do {
			salaire = s1.nextLine();
			if (!salaire.matches("\\d{1,9}\\,\\d{1,2}€")) {
				System.out.println("Rentrez un format correct");
			}
		}
			while (!salaire.matches("\\d{1,9}\\,\\d{1,2}€"));
		System.out.println("Etes vous un client : true/false ?");
		Boolean estClient = s1.nextBoolean();
		s1.nextLine();

		Personne monSal= new Salarie(nom, prenom , adresse,ville,cp, numSecu, salaire, estClient);
		System.out.println(monSal.toString());
		
		lc.add(monSal);
	}
	
	public static void creerPatron()
	{
		Creation.afficheGeneral();
		System.out.println("Quel est votre numero de secu ?");
		String numSecu = "";
		
		boolean reussi = false;
		while(reussi==false)
		{
		do {
			numSecu = s1.nextLine();
			if (!numSecu.matches("\\d{13}")) {
				System.out.println("Rentrez un format correct");
			}
			else {
				try {
					Salarie.UniqueSecu(numSecu, lc);
					reussi=true;
				} catch (ErreurSaisie e) {
					// TODO Auto-generated catch block
					System.out.println("Ce numéro existe déja");
					
				}
			}
		}
			while (!numSecu.matches("\\d{13}") && reussi==false);
		}
		System.out.println("Etes vous un client : true/false ?");
		Boolean estClient = s1.nextBoolean();

		System.out.println("Quel est votre salaire ?");
		String salaire;
		do {
			salaire = s1.nextLine();
			if (!salaire.matches("\\d{1,9}\\,\\d{1,2}€")) {
				System.out.println("Rentrez un format correct");
			}
		}
			while (!salaire.matches("\\d{1,9}\\,\\d{1,2}€"));
		
		IPatron monPatr= new Patron(nom, prenom , adresse,ville,cp, numSecu, salaire, estClient);
		System.out.println(monPatr.toString());			
		Patron.PatronExiste(lc);
		lc.add((Patron)monPatr);
	}
}
