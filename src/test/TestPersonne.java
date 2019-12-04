package test;

import static org.junit.Assert.*;

import org.junit.Test;

import projetPOO01.GestionPersonnes.Personne;

import org.junit.Before;


public class TestPersonne {
	private Personne p;
	private final String onom = "La";
	private final String oprenom = "Xavier";
	private final String oadresse = "Rue 4";
	private final String oville= "Lyon";
	private final String ocp= "74300";
	
	private final String setnom = "";
	private final String setprenom = "";
	private final String setadresse = "";
	private final String setville= "";
	private final String setcp= "";

	@Before
public void init()
{
	p = new Personne(onom, oprenom, oadresse, oville, ocp);
}
	
	@Test
	public void testGetNom() {
			assertEquals(onom, p.getNom());
			this.testSetNom();
	}

	@Test
	public void testSetNom() {
		p.setNom(setnom);
		assertEquals(setnom,p.getNom());

	}

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom, p.getPrenom());
		this.testSetPrenom();

	}

	@Test
	public void testSetPrenom() {
		p.setNom(setprenom);
		assertEquals(setprenom,p.getNom());
	}
	

	@Test
	public void testGetAdresse() {
		assertEquals(oadresse, p.getAdresse());
		this.testSetAdresse();
	}

	@Test
	public void testSetAdresse() {
		p.setAdresse(setadresse);
		assertEquals(setadresse,p.getAdresse());
	}

	@Test
	public void testGetVille() {
		assertEquals(oville, p.getVille());
		this.testSetVille();
	}

	@Test
	public void testSetVille() {
		p.setVille(setville);
		assertEquals(setville,p.getVille());
	}

	@Test
	public void testGetCodePostal() {
		assertEquals(ocp, p.getCodePostal());
		this.testSetCodePostal();
	}

	@Test
	public void testSetCodePostal() {
		p.setCodePostal(setcp);
		assertEquals(setcp,p.getCodePostal());
	}

	@Test
	public void testPersonne() {
			assertNotNull(p);
	}

	@Test
	public void testToString() {
		assertNotNull(p);
		assertEquals("PersonnePersonne [nom=La, prenom=Xavier, adresse=Rue 4, ville=Lyon, codePostal=74300]",p.toString());
		p.setVille("Marseille");
		assertEquals("PersonnePersonne [nom=La, prenom=Xavier, adresse=Rue 4, ville=Marseille, codePostal=74300]",p.toString());

	}

}
