package projetPOO01.menu;

import java.util.HashMap;
import java.util.Map;

public class AffichageMenu {
	private static String choix = null;

	public static void menuCreation()
	{
		Map<String, IExecute> im1 = new HashMap<String,IExecute>();

		
		im1.put("0 pour créer un client",Creation::creerClient);
		im1.put("1 pour créer un fournisseur",Creation::creerFournisseur);
		im1.put("2 pour créer un salarié",Creation::creerSalarie);
		im1.put("3 pour créer un patron",Creation::creerPatron);

		
		im1.keySet().stream().sorted().forEach(System.out::println);
		
		while(true) {
		
		choix = Creation.s1.next();
		
		im1.entrySet().stream().filter(e->e.getKey().charAt(0) == choix.charAt(0)).
		forEach(e->e.getValue().apply());
					
		}

	}
}
