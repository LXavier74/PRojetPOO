package projetPOO01.GestionPersonnes;

import java.util.List;

import projetPOO01.GestionsCommandes.Achat;

public interface IClient {
	
	public void achete(List<Achat> achat);
	public void paie();
	public boolean estClient();


	
}
