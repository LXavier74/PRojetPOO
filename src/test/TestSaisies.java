package test;

import static org.junit.Assert.*;

import org.junit.Test;

import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;
import static org.hamcrest.CoreMatchers.is;
public class TestSaisies {

	private String monCp="12345";
	
	@Test
	public void testCPOK() {
		try {
			Personne.testCP(monCp);
			Personne.testCP("1fds");
		}
		catch (ErreurSaisie e)
		{
			assertThat(e.getMessage(), is("Le format n'est pas correct"));
		}
		
	}


}
