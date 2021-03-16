package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String parolaAliena;
	private List<String> traduzione;
	
	public WordEnhanced(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzione=new ArrayList<>();
		this.traduzione.add(traduzione);
	}

	public List<String> getListaTraduzione() {
		return traduzione;
	}

	public void setTraduzione(List<String> traduzione) {
		this.traduzione = traduzione;
	}

	public String getParolaAliena() {
		return parolaAliena;
	}
	
	public void addTraduzione(String s) {
		this.traduzione.add(s);
	}
	
	public String toString() {
		String risultato="";
		int i;
		for(i=0; i<traduzione.size(); i++) {
			risultato=risultato+traduzione.get(i)+"\n";
		}
		return risultato;
	}

}
