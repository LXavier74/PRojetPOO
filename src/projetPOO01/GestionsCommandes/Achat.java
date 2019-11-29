package projetPOO01.GestionsCommandes;

import java.util.Calendar;
import java.util.Date;

public class Achat {

	private Date date;
	private String intitule;
	private int qte;
	public Date getDate() {
		return date;
	}
	public String getIntitule() {
		return intitule;
	}
	public int getQte() {
		return qte;
	}
	public Achat(String intitule, int qte) {
		super();
		this.date = Calendar.getInstance().getTime();
		this.intitule = intitule;
		this.qte = qte;
	}
	
}
