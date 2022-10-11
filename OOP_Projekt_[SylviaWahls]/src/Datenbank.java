import java.util.ArrayList;
import java.util.Scanner;

public class Datenbank {

	 // Instanzvariable vom Typ Arraylist für Fahrzeuge
	ArrayList<Fzg> fzgDatensaetze = new ArrayList<Fzg>();

    //Konstruktor
    public Datenbank() {
    	this.fzgDatensaetze = new ArrayList<Fzg>();
        this.fzgDatensaetze.add(new Pkw("Mercedes", "A Klasse", 2019, "rot", 23.444));
        this.fzgDatensaetze.add(new Lkw("Mercedes", "Sprinter", 2000, "weiß", 50000));
        this.fzgDatensaetze.add(new Boot("Sunseeker", "Mohawk 29", 2010, "rot", 20944));
        this.fzgDatensaetze.add(new Motorrad("Kawasaki", "Z 650", 2005, "grün", 7000));
    }
	
    public void addDatensatz(Fzg fzg) {
		
    	fzgDatensaetze.add(fzg);
	}
    
    
    
    public void loescheFzg(int fzgNr) {
    	 this.fzgDatensaetze.remove(fzgNr-1);
    }
    
    public ArrayList<Fzg> gibDatensaetze() {
        return this.fzgDatensaetze;
    }
    
   
    
    public ArrayList<Fzg> fzgSuchen(String suchbegriff){
    	ArrayList<Fzg> ergebnisse = new ArrayList<Fzg>();
    	
    	for (int i = 0; i < fzgDatensaetze.size(); i++) {
   		 Fzg aktuellesFzg = this.fzgDatensaetze.get(i);
   		 if (aktuellesFzg.getMarke().contains(suchbegriff)) {
   			 ergebnisse.add(aktuellesFzg);
   		 }
   		 else if (aktuellesFzg.getModell().contains(suchbegriff)) {
   			 ergebnisse.add(aktuellesFzg);
   		 }
   		else if (((Integer)aktuellesFzg.getBaujahr()).toString().contains(suchbegriff)) {
  			 ergebnisse.add(aktuellesFzg);
  		 }
   		else if (aktuellesFzg.getFarbe().contains(suchbegriff)) {
  			 ergebnisse.add(aktuellesFzg);
  		 }
   		else if (((Double)aktuellesFzg.getPreis()).toString().contains(suchbegriff)) {
  			 ergebnisse.add(aktuellesFzg);
  		 }
   	
    	}
    	return ergebnisse;
    }
    
    public void fzgLoeschen(int fzgNr) {
    
    	
          
            	if (this.fzgDatensaetze.get(fzgNr - 1) != null) {
            		System.out.println("Datensatz wirklich löschen? Ja(j) oder Nein(n)");
            		String eingabeJN = new Scanner(System.in).next();
        			
        			switch (eingabeJN.toUpperCase()) {
                    case "J":
                    	this.fzgDatensaetze.remove(fzgNr - 1);
                        return;
                    case "N":
                        return;
                    default:
                        throw new IllegalArgumentException("Nur j/J für Ja und n/N für Nein ist zulässig.");
        			}
            	}
            	
            	else {
            		throw new IllegalArgumentException("Falsche Eingabe. Zurück ins Hauptmenü");
            		
            	}
               
            
    	}
    }

