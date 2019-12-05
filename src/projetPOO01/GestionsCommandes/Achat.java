package projetPOO01.GestionsCommandes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Achat {

	private Date date;
	private String intitule;
	private String qte;
	String pattern = "dd/MM/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("fr", "FR"));


	public Date getDate() {
		return date;
	}
	public String getIntitule() {
		return intitule;
	}
	@Override
	public String toString() {
		return "Achat [date=" + date + ", intitule=" + intitule + ", qte=" + qte + ","
				+ "]";
	}
	public String getQte() {
		return qte;
	}
	public Achat(String date, String intitule, String qte) {
		super();
		try {
			this.date =  simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
System.out.println("Problème d'achat");
}
		this.intitule = intitule;
		this.qte = qte;
	}
	
}
