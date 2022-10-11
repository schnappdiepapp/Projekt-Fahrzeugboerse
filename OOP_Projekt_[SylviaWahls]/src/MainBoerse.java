import java.util.ArrayList;
import java.util.Scanner;

public class MainBoerse {

	public static void main(String[] args) {

		MainBoerse boerse = new MainBoerse();
		boerse.hauptMenue();
		

	}
	
	Datenbank db;
	public MainBoerse() {
		this.db = new Datenbank();
	}
	
		
    

	 final String HAUPTMENUE = 
			 "\n\n------------------------------------------------\n"
			+ "Fahrzeugbörse    Hauptmenü    von: Sylvia Wahls\n"
			+ "------------------------------------------------\n"
			+ "1) Fahrzeug anlegen\n" + "2) Fahrzeug bearbeiten\n" + "3) Fahrzeug suchen\n" + "4) Fahrzeug löschen\n"
			+ "5) Liste anzeigen\n" + "6) Börse beenden\n"
			+ "------------------------------------------------\n"
			+ "Bitte wählen:\n";

	public  void hauptMenue() {

		do {
			System.out.println(HAUPTMENUE);
			switch (new Scanner(System.in).next()) {
			case "1":
				fzgAnlegen();
				System.out.println("Falls Sie ein weiteres Fahrzeug anlegen wollen, wählen Sie im Hauptmenü den Punkt '1) Fahrzeug anlegen' aus");
				break;
				
			case "2":
				fzgBearbeiten();
				break;
			case "3":
				fzgSuchen();
				break;
			case "4":
				fzgLoeschen();
				break;
			case "5":
				zeigeDatensaetze(db.gibDatensaetze());
				break;
			case "6":
				boerseBeenden();
				break;
			default:
				fehlerhafteEingabe();
				hauptMenue();
			}

		} while (true);
	}



	
	
	
	private  void fzgAnlegen() {
		
		System.out.println("Überlege Dir, welches Fahrzeug es sein soll:\n\nPKW, LKW, Boot, Motorrad\n");
		
		System.out.println("\nGib nun folgende Kriterien ein: \n");
		System.out.println("Fahrzeug, Marke, Modell, Baujahr, Farbe, Preis\n");
		System.out.println("Beispiel:");
		System.out.println("PKW, VW, Golf, 2020, schwarz, 11000.40");
		String eingabe = new Scanner(System.in).nextLine();
		String[] attribute = eingabe.split(", ");
		try {
			if (attribute.length != 6) {
				throw new IllegalArgumentException("Auflistung der Attribute falsch oder fehlend!");
			}
			String fzgTyp = attribute[0];
			String marke = attribute[1];
			String modell = attribute[2];
			int baujahr = Integer.parseInt(attribute[3]);
			String farbe = attribute[4];
			double preis = Double.parseDouble(attribute[5]);

			Fzg fzg;
			switch (fzgTyp.toUpperCase()) {
            case "PKW":
                fzg = new Pkw(marke, modell, baujahr, farbe, preis);
                break;
            case "LKW":
            	  fzg = new Lkw(marke, modell, baujahr, farbe, preis);
                  break;
            case "BOOT":
            	  fzg = new Boot(marke, modell, baujahr, farbe, preis);
                  break;
            case "MOTORRAD":
            	  fzg = new Motorrad(marke, modell, baujahr, farbe, preis);
                  break;
            default:
            	throw new IllegalArgumentException("Kein gültiger Fahrzeugtyp!");
			}
			
			db.addDatensatz(fzg);
			System.out.println("\nNeues Fahrzeug wurde angelegt.\n");
			
        
			
		} catch (IllegalArgumentException e) {
			System.out.println("Konnte nicht abgespeichert werden.");
			System.out.println(e.getMessage());
			System.out.println("Zurück ins Hauptmenü");
			
		}
	}



	private void fehlerhafteEingabe() {
		System.out.println("Fehlerhafte Eingabe! Zurück ins Hauptmenü");
		
	}

	public  void fzgBearbeiten() {
		System.out.println("Fahrzeug bearbeiten\n");
	
		zeigeDatensaetze(db.gibDatensaetze());
		
		 System.out.println("\nGib Nummer des Fahrzeugs ein zum Bearbeiten des Datensatzes!");
	        try {
	            int fzgNr = gibZahlEin();
	            fzgAnlegen();
	            db.loescheFzg(fzgNr);
	           
	        } catch (NumberFormatException e) {
	            System.out.println(("Falsche Eingabe! Fahrzeug-Nummer existiert nicht.")); // Programm läuft weiter
	        }
		
		

	}

	public  void fzgSuchen() {
		System.out.println("Suchbefehl eingeben: ");
		String eingabe = new Scanner(System.in).next();
		zeigeDatensaetze(db.fzgSuchen(eingabe));
	}
	    

	public  void fzgLoeschen() {
	     zeigeDatensaetze(db.gibDatensaetze());
	        System.out.println("\nGib Nummer des Fahrzeugs ein zum Löschen des Datensatzes!");
	        try {
	            db.fzgLoeschen(gibZahlEin());
	            System.out.println("Das Fahrzeug wurde gelöscht.");
	        } catch (NumberFormatException e) {
	            System.out.println(("Falsche Eingabe! Fahrzeug-Nummer existiert nicht.")); // Programm läuft weiter
	        }
	    }


	    private Integer gibZahlEin() {
	        Scanner sc = new Scanner(System.in);
	        return Integer.parseInt(sc.next());
	    }


	

	public  void boerseBeenden() {
 
		System.out.println("Fahrzeugbörse wirklich beenden? Ja(j) oder Nein(n)");
		String eingabeJN = new Scanner(System.in).next();
		
		switch (eingabeJN.toUpperCase()) {
        case "J":
        	System.out.println("\nTschüss!\n");
    		System.exit(0);
        case "N":
            return;
        default:
        	System.out.println("Nur j/J für Ja und n/N für Nein ist zulässig. Zurück ins Hauptmenü");
            return;
		}
		
	}
	
	private void zeigeDatensaetze(ArrayList<Fzg> arrayList) {
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s","Nr.", "Fahrzeug", "Marke", "Modell", "Baujahr", "Farbe", "Preis\n"));
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null) {
                Fzg fzg = arrayList.get(i);
                System.out.println(String.format("%-10d%-15s%-15s%-15s%-15d%-15s%-15.2f", (i+1), fzg.getTyp(), fzg.getMarke(),
                        fzg.getModell(), fzg.getBaujahr(), fzg.getFarbe(), fzg.getPreis()));

            }
        }
    }

}
