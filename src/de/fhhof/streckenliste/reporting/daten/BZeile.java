package de.fhhof.streckenliste.reporting.daten;

public class BZeile {
	private BWildart bWildart;
	private int bAnzErlegt;
	private int bAnzFallVerend;
	private int bAnzFallVerkehr;
	private String bBemerk;
	
	public BZeile() {
		
	}	
	
	public BZeile(BWildart bWildart, int bAnzErlegt, int bAnzFallVerend,
			int bAnzFallVerkehr, String bBemerk) {
		super();
		this.bWildart = bWildart;
		this.bAnzErlegt = bAnzErlegt;
		this.bAnzFallVerend = bAnzFallVerend;
		this.bAnzFallVerkehr = bAnzFallVerkehr;
		this.bBemerk = bBemerk;
	}
	
	public BWildart getbWildart() {
		return bWildart;
	}
	public void setbWildart(BWildart bWildart) {
		this.bWildart = bWildart;
	}
	public int getbAnzErlegt() {
		return bAnzErlegt;
	}
	public void setbAnzErlegt(int bAnzErlegt) {
		this.bAnzErlegt = bAnzErlegt;
	}
	public int getbAnzFallVerend() {
		return bAnzFallVerend;
	}
	public void setbAnzFallVerend(int bAnzFallVerend) {
		this.bAnzFallVerend = bAnzFallVerend;
	}
	public int getbAnzFallVerkehr() {
		return bAnzFallVerkehr;
	}
	public void setbAnzFallVerkehr(int bAnzFallVerkehr) {
		this.bAnzFallVerkehr = bAnzFallVerkehr;
	}
	public String getbBemerk() {
		return bBemerk;
	}
	public void setbBemerk(String bBemerk) {
		this.bBemerk = bBemerk;
	}
}
