package projetPOO01.Controles;

import java.text.SimpleDateFormat;

import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Exceptions.ErreurSaisie;

public class Controles {
	public static void ctrlInt(String s) throws ErreurSaisie
	{
		
		try {
			Integer.parseInt(s);			
		}
		catch (Exception e)
		{
			throw new ErreurSaisie("Vous devez rentrer des chiffres");
		}

	}
	
	public static void ctrlDate(String s) throws ErreurSaisie
	{
		try {
			SimpleDateFormat sdf = new SimpleDateFormat () ;
	        sdf.applyPattern("dd/MM/yyyy") ;
	        sdf.setLenient(false) ;      
	        sdf.parse(s) ;
	        	
		}
		catch(Exception e)
		{
			throw new ErreurSaisie("La date n'est pas correcte");
		}
		
	}
	

	

}
