package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.GestionsCommandes.Achat;

public class TestSalarie {
	private Salarie s;
	private final String onom = "La";
	private final String oprenom = "Xavier";
	private final String oadresse = "Rue 4";
	private final String oville= "Lyon";
	private final String ocp= "74300";
	private final String osecu= "1234567891234";
	private final String osalaire= "120,00€";
	private final boolean ocli= true;

	private final String odate= "20/12/2012";
	private final String odesc= "Achat d'un iphone";
	private final int oqt= 11;

	
	
	

	@Before
public void init()
{
		s = new Salarie(onom, oprenom, oadresse, oville, ocp, osecu, osalaire, ocli);
}    
	@Test
	public void testToString() {
assertNotNull(s.toString());
assertEquals("Salarie [numSecu=1234567891234, salaire=120,00€, toString()=SalariePersonne [nom=La, prenom=Xavier, adresse=Rue 4, ville=Lyon, codePostal=74300]]", s.toString());
	}

	@Test
	public void testSalarie() {
		assertNotNull(s);
	}

	@Test
	public void testPaie() {
	}

	@Test
	public void testGetNumSecu() {
		assertEquals(osecu, s.getNumSecu());
	}

	@Test
	public void testGetSalaire() {
		assertEquals(osalaire, s.getSalaire());
	}

	@Test
	public void testAchete() {
		List <Achat> achats = new ArrayList<Achat>();
		Achat monAchat = new Achat(odate, odesc, oqt);
		achats.add(monAchat);
		s.achete(achats);
		assertEquals(achats, s.getAchats());
	}

	@Test
	public void testUniqueSecu() {
	}

	@Test
	public void testEstClient() {
		assertEquals(ocli, s.estClient());
	}

}
