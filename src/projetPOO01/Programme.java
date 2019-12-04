package projetPOO01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

public class Programme {
	static Scanner s1 = new Scanner(System.in);
	static List<Personne> lc = new ArrayList<Personne>();
	static List<Achat> la = new ArrayList<Achat>();
	static List <IClient> ic = new ArrayList();
	static List <IFournisseur> iff;
	static List<Commande> lco = new ArrayList<Commande>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	IClient cl1 = new Client("","","","","");
		IClient cl2 = new Fournisseur("","","","","");
		Programme.gereClient(cl1);
		Programme.gereClient(cl2);
		Personne p1 = new Client("","","","","");
		Salarie s1 = new Salarie("","","","","");
		List<Personne> lp = new ArrayList<Personne>();
		lp.add(p1);
		lp.add(s1);
		*/
		boolean arret=false;

		while (arret==false)
			
		{
		System.out.println("1 = client , 2 = fournisseur, 3 = salarie, 4 = liste client, 5 = liste fournisseur, 6 = liste salarie, 7 = liste générale");


		System.out.println("Que voulez vous ajouter ?");
		String choix = s1.nextLine();
		switch (choix) {
		  case "1":
			  Programme.creerClient();
				break;
		  case "2":
			  Programme.creerFournisseur();
				  break;
		  case "3": 
			Programme.creerSalarie();
				  break;
		  case "4":
			Programme.listeClients();
				  break;
		  case "5":
				Programme.listeFournisseurs();
				  break;
		  case "6":
				Programme.listeSalaries();
				  break;
		  case "7":
				Programme.listeGenerale();
				  break;
		  case "8":
				Programme.creerPatron();
				  break;
		  case "9":
				Programme.patron();
				  break;
		  default:
				System.out.println("Vous avez fait une erreur");
				break;
		}
		System.out.println("Vous voulez arrêter");	
		
		String arr = s1.nextLine();
		
		if(arr.equals("oui"))
		{
			arret=true;
		}
		
		
		}
		
		System.out.println("ARRET");

		
		
		

		
	}

	
	public static void listeGenerale() {
		System.out.println("Vous voulez une liste générale");
		
		for(Personne c:lc)
		{
		
			System.out.println(c);
		
		}		
	}

	public static void creerClient()
	{
		System.out.println("Vous voulez ajouter un client");
		System.out.println("Quel est votre nom ?");
		String nomCli = s1.nextLine();
		System.out.println("Quel est votre prénom ?");
		String prenomCli = s1.nextLine();
		System.out.println("Quel est votre adresse ?");
		String adresseCli = s1.nextLine();
		System.out.println("Quel est votre ville ?");
		String villeCli = s1.nextLine();
		
		boolean reussi = false;
		String cpCli ="";
		while(reussi==false)
		{
		System.out.println("Quel est votre code postal ?");
		cpCli = s1.nextLine();
		try {
			Client.testCP(cpCli);
			reussi=true;
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			System.out.println("erreur de saisie");
		}
		}
		
		String numCli = "";
		
		reussi=false;
		while(reussi==false)
		{
			System.out.println("Quel est votre numero client ?");

			numCli = s1.nextLine();
	
			
				try {
					Client.UniqueCli(numCli, lc);
					try {
						Programme.ctrlInt(numCli);
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

		Personne monCli= new Client(nomCli, prenomCli , adresseCli,villeCli,cpCli,numCli, estFournisseur);
		System.out.println(monCli.toString());
		lc.add(monCli);
		
		}
	

		
	public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}


	
	
	
	

	public static void creerFournisseur()
	{
		System.out.println("Vous voulez ajouter un fournisseur");
		
		System.out.println("Quel est votre nom ?");
		String nomFour = s1.nextLine();
		System.out.println("Quel est votre prénom ?");
		String prenomFour = s1.nextLine();
		System.out.println("Quel est votre adresse ?");
		String adresseFour = s1.nextLine();
		System.out.println("Quel est votre ville ?");
		String villeFour = s1.nextLine();
		System.out.println("Quel est votre code postal ?");
		String cpFour = s1.nextLine();
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
		Personne monFour= new Fournisseur(nomFour, prenomFour , adresseFour,villeFour,cpFour,numFour, estClient);
		System.out.println(monFour.toString());
		
		lc.add(monFour);
	}
	
	
	public static void creerSalarie()
	{
		System.out.println("Vous voulez ajouter un salarie");
		System.out.println("Quel est votre nom ?");
		String nomSal = s1.nextLine();
		System.out.println("Quel est votre prénom ?");
		String prenomSal = s1.nextLine();
		System.out.println("Quel est votre adresse ?");
		String adresseSal = s1.nextLine();
		System.out.println("Quel est votre ville ?");
		String villeSal = s1.nextLine();
		System.out.println("Quel est votre code postal ?");
		String cpSal = s1.nextLine();
		String numSecu="";

		boolean reussi = false;
		while(reussi==false)
		{
			System.out.println("Quel est votre numero de secu ?");
			numSecu = s1.nextLine();
		
			
				try {
					Salarie.UniqueSecu(numSecu, lc);
				} catch (ErreurSaisie e) {
					// TODO Auto-generated catch block
					System.out.println("Ce numéro existe déja");
					
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

		Personne monSal= new Salarie(nomSal, prenomSal , adresseSal,villeSal,cpSal, numSecu, salaire, estClient);
		System.out.println(monSal.toString());
		
		lc.add(monSal);
	}
	
	
	

	public static void creerPatron()
	{
		System.out.println("Vous voulez ajouter un salarie");
		System.out.println("Quel est votre nom ?");
		String nomSal = s1.nextLine();
		System.out.println("Quel est votre prénom ?");
		String prenomSal = s1.nextLine();
		System.out.println("Quel est votre adresse ?");
		String adresseSal = s1.nextLine();
		System.out.println("Quel est votre ville ?");
		String villeSal = s1.nextLine();
		System.out.println("Quel est votre code postal ?");
		String cpSal = s1.nextLine();
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
		
		IPatron monPatr= new Patron(nomSal, prenomSal , adresseSal,villeSal,cpSal, numSecu, salaire, estClient);
		System.out.println(monPatr.toString());			
		Patron.PatronExiste(lc);
		lc.add((Patron)monPatr);
	}
	public static void listeClients()
	{
		System.out.println("Vous voulez la liste des clients");
		int compteur=0;
		int num1=0;
		String num="";
		String dat="";
		String descr="";
		String qt = "";
		for(Personne c:lc)
		{
			if (c instanceof IClient && ((IClient) c).estClient()==true)
			{
				compteur++;
			System.out.println(c + "n° " + compteur);
			ic.add((IClient) c);
			}
		}
			boolean ok=false;
			boolean reussi = false;
			while (ok==false)
			{
				
			
			while(reussi==false)
			{
				System.out.println("Quel client souhaite faire des achats");
				 num = s1.nextLine();	
				try {
			
					Programme.ctrlInt(num);
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
			 dat = s1.nextLine();
			 try {
				Programme.ctrlDate(dat);
				reussi=true;
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				reussi=false;
				System.out.println("erreur de saisie sur ladate");
			}
			 
			}
			System.out.println("Description de l'achat");
			 descr = s1.nextLine();
			

			 reussi = false;
			while(reussi==false)
			{
				System.out.println("Quantité demandée");
				 qt = s1.nextLine();
				

				try {
			
					Programme.ctrlInt(qt);
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
			Achat monAchat = new Achat (dat, descr, Integer.parseInt(qt));
			la.add(monAchat);

			System.out.println("Souhaitez vous faire un autre achat: tapez non si vous ne voulez pas");
			String rep = s1.nextLine();
			{
				if (rep.equals("non"))
				{
					ok=true;
				}
			
			}
			}
			
		
				
			
			
			ic.get(num1).achete(la);
			ic.get(num1).paie();
			for(Achat a:la)
			{
				System.out.println(a);
			}
		
		

	}
	
	public static void ctrlInt(String s) throws ParseException
	{
		
		
		Integer.parseInt(s);

	}
	
	public static void ctrlDate(String s) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat () ;
        sdf.applyPattern("dd/MM/yyyy") ;
        sdf.setLenient(false) ;      
        sdf.parse(s) ;
        
		
	}
	public static void listeFournisseurs()
	{
		System.out.println("Vous voulez la liste des fournisseurs");
		int compteur=0;

		for(Personne c:lc)
		{
			if (c instanceof IFournisseur && ((IFournisseur) c).estFournisseur()==true)
			{
			System.out.println(c+ "n° " + compteur);
			iff.add((IFournisseur) c);
			}
		}
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
			 num = s1.nextLine();	
			try {
		
				Programme.ctrlInt(num);
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
		 dat = s1.nextLine();
		 try {
			Programme.ctrlDate(dat);
			reussi=true;
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			reussi=false;
			System.out.println("erreur de saisie sur ladate");
		}
		 
		}
		System.out.println("Description de la commande");
		 descr = s1.nextLine();
		

		 reussi = false;
		while(reussi==false)
		{
			System.out.println("Quantité demandée");
			 qt = s1.nextLine();
			

			try {
		
				Programme.ctrlInt(qt);
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
		Commande maCommande= new Commande (dat, descr, Integer.parseInt(qt));
		lco.add(maCommande);

		System.out.println("Souhaitez vous faire un autre commande: tapez non si vous ne voulez pas");
		String rep = s1.nextLine();
		{
			if (rep.equals("non"))
			{
				ok=true;
			}
		
		}
		}
		
		
		iff.get(num1).commander(lco);
		iff.get(num1).livrer();
		for(Commande c:lco)
		{
			System.out.println(c);
		}
		
		
	}
	public static void listeSalaries()
	{
		System.out.println("Vous voulez la liste des salariés");
		
		for(Personne c:lc)
		{
			if (c instanceof Salarie)
			{
			System.out.println(c);
			}
		}
	}
	
	public static void patron()
	{
		
		for(Personne c:lc)
		{
			if (c instanceof Patron)
			{
			System.out.println(c);
			}
		}
	}
	
	
}
