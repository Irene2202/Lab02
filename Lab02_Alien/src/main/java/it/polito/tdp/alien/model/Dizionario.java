package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dizionario {
	//Map<String, Word> dizionario;
	Map<String, WordEnhanced> dizionario;
	public Dizionario() {
		dizionario=new HashMap<>();
	}
	
	public void addWord(String alieno, String traduzione) {
		if(this.parolaGiaPresente(alieno, traduzione)==false) {
			WordEnhanced w=new WordEnhanced(alieno, traduzione);
			dizionario.put(w.getParolaAliena(), w);
		}
	}
	/* Metodo con uso classe Word
	public Word ricercaTraduzione(String s) {
		return this.dizionario.get(s);
	}*/
	
	public String ricercaTraduzione(String alieno) {
		WordEnhanced risultato=this.dizionario.get(alieno);
		if(risultato!=null) {
			return risultato.toString();
		}
		return null;
	}
	
	public boolean parolaGiaPresente(String alieno, String traduzione) {
		WordEnhanced trovata=this.dizionario.get(alieno);
		if(trovata==null)
			return false;
		trovata.addTraduzione(traduzione);
		return true;
		/*Con classe Word
		 * if(trovata.getTraduzione()!=w.getTraduzione()) {
			trovata.setTraduzione(w.getTraduzione());
			return true;
		} 
		else
			return true;*/
	}
	
	public void clear() {
		dizionario.clear();
	}

}
