
public class Fzg {
	protected String typ;
	private String marke, modell, farbe;
	private int baujahr;
	private double preis;
	
	public Fzg(String marke, String modell, int baujahr, String farbe, double preis) {
		this.typ = "unspez.Fzg";
		this.marke = marke;
		this.modell = modell;
		this.baujahr = baujahr;
		this.farbe = farbe;
		this.preis = preis;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}
	
	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getTyp() {
		return typ;
	}
}
