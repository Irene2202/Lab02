package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dizionario {
	Map<String, Word> dizionario;
	
	public Dizionario() {
		dizionario=new HashMap<>();
	}
	
	public void addWord(Word w) {
		if(this.parolaGiaPresente(w)==false) {
			dizionario.put(w.getParolaAliena(), w);
		}
	}
	
	public Word ricercaTraduzione(String s) {
		return this.dizionario.get(s);
	}
	
	public boolean parolaGiaPresente(Word w) {
		Word trovata=this.dizionario.get(w.getParolaAliena());
		if(trovata==null)
			return false;
		if(trovata.getTraduzione()!=w.getTraduzione()) {
			trovata.setTraduzione(w.getTraduzione());
			return true;
		} 
		else
			return true;
	}

}
