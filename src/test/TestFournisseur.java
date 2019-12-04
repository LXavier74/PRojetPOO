package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionsCommandes.Achat;
import projetPOO01.GestionsCommandes.Commande;

public class TestFournisseur {
	private Fournisseur f;
	private final String onom = "La";
	private final String oprenom = "Xavier";
	private final String oadresse = "Rue 4";
	private final String oville= "Lyon";
	private final String ocp= "74300";
	private final String onf= "1";
	private final boolean estFour=true;
	private final boolean estCli=true;

	private final String odate= "20/12/2012";
	private final String odesc= "Achat d'un iphone";
	private final int oqt= 11;

	@Before
public void init()
{
	f = new Fournisseur(onom, oprenom, oadresse, oville, ocp, onf, estCli );
}
	
	
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListeCommande() {
		List <Commande> commandes = new ArrayList<Commande>();
		Commande maCommande = new Commande(odate, odesc, oqt);
		commandes.add(maCommande);
		f.commander(commandes);
		assertEquals(commandes, f.getListeCommande());	
		}

	@Test
	public void testFournisseur() {
		assertNotNull(f);
	}

	@Test
	public void testPaie() {

	}

	@Test
	public void testLivrer() {

	}

	@Test
	public void testGetNumFournisseur() {
		assertEquals(onf, f.getNumFournisseur());
	}

	@Test
	public void testEstClient() {
		assertEquals(estCli, f.estClient());
	}

	@Test
	public void testUniqueFour() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchete() {
		List <Achat> achats = new ArrayList<Achat>();
		Achat monAchat = new Achat(odate, odesc, oqt);
		achats.add(monAchat);
		f.achete(achats);
		assertEquals(achats, f.getListeAchat());		}

	@Test
	public void testCommander() {
		List <Commande> commandes = new ArrayList<Commande>();
		Commande maCommande = new Commande(odate, odesc, oqt);
		commandes.add(maCommande);
		f.commander(commandes);
		assertEquals(commandes, f.getListeCommande());		}

	@Test
	public void testEstFournisseur() {
		assertEquals(estFour, f.estFournisseur());
	}

	@Test
	public void testGetListeAchat() {
		List <Achat> achats = new ArrayList<Achat>();
		Achat monAchat = new Achat(odate, odesc, oqt);
		achats.add(monAchat);
		assertEquals(monAchat, f.getListeAchat());;
	}

}
