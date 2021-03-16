package it.polito.tdp.alien.model;

public class Word {
	private String parolaAliena;
	private String traduzione;
	
	public Word(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public void setParolaAliena(String parolaAliena) {
		this.parolaAliena = parolaAliena;
	}

	public String getTraduzione() {
		return traduzione;
	}

	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}
		

}
