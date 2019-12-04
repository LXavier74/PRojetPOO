package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionsCommandes.Achat;

public class TestClient {
	private Client c;
	private final String onom = "La";
	private final String oprenom = "Xavier";
	private final String oadresse = "Rue 4";
	private final String oville= "Lyon";
	private final String ocp= "74300";
	private final String oncli= "1";
	private final boolean estFour=false;
	private final boolean estCli=true;

	private final String odate= "20/12/2012";
	private final String odesc= "Achat d'un iphone";
	private final int oqt= 11;

	
	@Before
public void init()
{
		c = new Client(onom, oprenom, oadresse, oville, ocp, oncli,estFour);
}   

	
	@Test
	public void testToString() {
		assertEquals("Client [numClient=1, estClient=true, estFournisseur=false, achats=null, toString()=ClientPersonne [nom=La, prenom=Xavier, adresse=Rue 4, ville=Lyon, codePostal=74300]]", c.toString());
	}

	@Test
	public void testClient() {
		assertNotNull(c);
	}

	@Test
	public void testLivrer() {
	}

	@Test
	public void testPaie() {
	}

	@Test
	public void testGetNumClient() {
		assertEquals(oncli, c.getNumClient());
	}

	@Test
	public void testUniqueCli() {
	}

	@Test
	public void testEstClient() {
		assertEquals(estCli, c.estClient());
	}

	@Test
	public void testCommander() {
		
	}

	@Test
	public void testEstFournisseur() {
		assertEquals(estFour, c.estFournisseur());
	}

	@Test
	public void testAchete() {
		List <Achat> achats = new ArrayList<Achat>();
		Achat monAchat = new Achat(odate, odesc, oqt);
		achats.add(monAchat);
		c.achete(achats);
		assertEquals(achats, c.getAchats());	
		}

}
