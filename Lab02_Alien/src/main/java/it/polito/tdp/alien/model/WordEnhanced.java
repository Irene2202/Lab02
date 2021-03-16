package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String parolaAliena;
	private List<String> traduzione;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parolaAliena == null) ? 0 : parolaAliena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}

	public WordEnhanced(String parolaAliena, String traduzione) {
		this.parolaAliena = parolaAliena;
		this.traduzione=new ArrayList<>();
		this.traduzione.add(traduzione);
	}

	public List<String> getListaTraduzione() {
		return traduzione;
	}

	public String getParolaAliena() {
		return parolaAliena;
	}
	
	public void addTraduzione(String s) {
		this.traduzione.add(s);
	}
	
	public String toString() {
		String risultato="Traduzione di "+parolaAliena+":\n";
		int i;
		for(i=0; i<traduzione.size(); i++) {
			risultato=risultato+traduzione.get(i)+"\n";
		}
		return risultato;
	}

}
