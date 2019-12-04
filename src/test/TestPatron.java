package test;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import projetPOO01.GestionPersonnes.Patron;

public class TestPatron {

	
	private Patron p;
	private final String onom = "La";
	private final String oprenom = "Xavier";
	private final String oadresse = "Rue 4";
	private final String oville= "Lyon";
	private final String ocp= "74300";
	private final String osecu= "1234567891234";
	private final String osalaire= "120,00€";
	private final boolean ocli= false;

	@Before
	public void init()
	{
		p = new Patron(onom, oprenom, oadresse, oville, ocp, osecu, osalaire, ocli);
	}
	@Test
	public void testToString() {
		assertEquals("Patron [toString()=Salarie [numSecu=1234567891234, salaire=120,00€, toString()=PatronPersonne [nom=La, prenom=Xavier, adresse=Rue 4, ville=Lyon, codePostal=74300]]]", p.toString());
	}

	@Test
	public void testPatron() {
		assertNotNull(p);
	}

	@Test
	public void testEmbauche() {
	}

	@Test
	public void testLicenciement() {
	}

	@Test
	public void testPaieSalarie() {
	}

	@Test
	public void testPatronExiste() {
	
	}

}
