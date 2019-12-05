package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import projetPOO01.Programme;
import projetPOO01.Controles.Controles;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class TestSaisies {

	private String monCp="12345";
	private String monCp5Chif="123456";
	private String monCpLettres="abcde";

	@Test
	public void testCP() {
		try {
			Personne.testCP(monCp);
			Personne.testCP(monCp5Chif);
		}
		catch (ErreurSaisie e)
		{
			assertThat(e.getMessage(), is("Il faut 5 caractères"));
		}
		try {
			Personne.testCP(monCpLettres);
			Personne.testCP(monCp);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Il ne faut que des chiffres"));
		}
		
	}
	private String monSecu="1234567891234";
	private String monSecu13="123456123";
	private String monSecuLettre="123456789123a";
	static List<Personne> ls = new ArrayList<Personne>();
	Salarie monSal= new Salarie("La", "Xavier", "440 C", "Lyon", "69300", monSecu, "120,00€", false);
	Client monCli= new Client("La", "Xavier", "440 C", "Lyon", "69300", "1", false);
	Fournisseur monFour= new Fournisseur("La", "Xavier", "440 C", "Lyon", "69300", "1", false);

	@Test
	public void testSecu() {
		try {
			ls.add(monSal);
			Salarie.UniqueSecu("1234567891284", ls);
		}
		catch (ErreurSaisie e)
		{
			assertThat(e.getMessage(), not("Ce numéro existe déja"));
			assertThat(e.getMessage(), not("Il faut des chiffres"));
			assertThat(e.getMessage(), not("il faut 13 caractères"));

		}
		try {
			ls.add(monSal);
			Salarie.UniqueSecu(monSecu, ls);

		}
		catch (ErreurSaisie e)
		{
			assertThat(e.getMessage(), is("Ce numéro existe déja"));
		}
		
		try {
			Salarie.SecuNombreFormat(monSecuLettre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Il faut des chiffres"));
		}
		
		try {
			Salarie.SecuNombre(monSecu13);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("il faut 13 caractères"));
		}
		
		
	}
	
	@Test
	public void testNumClient() {
		try {
			ls.add(monCli);
			Client.UniqueCli("2", ls);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), not("Ce numéro existe déja"));
		}
		try {
			ls.add(monCli);
			Client.UniqueCli("1", ls);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Ce numéro existe déja"));
		}

		
	}
	@Test
	public void testNumFour() {
		try {
			ls.add(monFour);
				Fournisseur.UniqueFour("2", ls);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), not("Ce numéro existe déja"));
		}
		try {
			ls.add(monFour);
			Fournisseur.UniqueFour("1", ls);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Ce numéro existe déja"));
		}

		
	}
	private final String odate= "20/12/2012";
	private final String odesc= "Achat d'un iphone";
	private final String oqt= "11";
	private final String opadate= "1fd1";
	
	@Test
	public void testCreerUnAchat() {
		List <Achat> achats = new ArrayList<Achat>();
		Achat monAchat = new Achat(odate, odesc, oqt);
		
		achats.add(monAchat);
		
		assertNotNull(monAchat);
		assertNotNull(achats);

		try {
			Controles.ctrlInt(oqt);
			Controles.ctrlInt("fds");
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("Vous devez rentrer des chiffres"));
		}
		try {
			Achat monAchatFaux = new Achat(opadate,"fds", "dsf");
			achats.add(monAchat);
			Controles.ctrlDate(opadate);
		} catch (ErreurSaisie e) {
			// TODO Auto-generated catch block
			assertThat(e.getMessage(), is("La date n'est pas correcte"));
		}
		
	}
	
	
	@Test
	public void testCreerUneCommande() {
		List <Commande> commandes = new ArrayList<Commande>();
		Commande maCommande = new Commande(odate, odesc, oqt);
		
		commandes.add(maCommande);
		
		assertNotNull(maCommande);
		assertNotNull(commandes);

		
		
		
	}
	
	
	}

