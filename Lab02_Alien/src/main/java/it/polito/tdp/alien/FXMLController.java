package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import it.polito.tdp.alien.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleClear(ActionEvent event) {
    	//this.model.clear();
    	txtResult.clear();
    	txtParola.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String testo=txtParola.getText().toLowerCase();

    	if(testo.isEmpty()) {
    		txtResult.setText("Inserire la parola da cercare");
    		return;
    	}
    	
    	if(testo.contains(" ")==true) {
    		String[] parole=testo.split(" ");
    		if(parole.length>2) {
    			txtResult.setText("ERRORE: formato errato");
    			return;
    		}
    		String parolaAliena=parole[0];
    		String traduzione=parole[1];
    		if((this.caretteriValidi(parolaAliena) && this.caretteriValidi(traduzione))==false) {
    			txtResult.setText("ERRORE: formato errato");
    			return;
    		}
    		//Word w=new Word(parolaAliena, traduzione);
    		//model.addWord(w);
    		model.addWord(parolaAliena, traduzione);
    		txtResult.setText("Inserimento nuova traduzione avvenuto con successo");
    		txtParola.clear();
    		return;
    	}
    	if(this.caretteriValidi(testo)==false) {
    		txtResult.setText("ERRORE: formato errato");
    		return;
    	}
    	
    	String risultato=this.model.ricercaTraduzione(testo);
    	if(risultato==null) {
    		txtResult.setText("Parola non presente nel dizionario");
    	}
    	else {
    		txtResult.setText(risultato);
    	}
    	
    	
    	/* Con uso classe Word
    	Word w=model.ricercaTraduzione(testo);
    	if(w!=null) {
    		txtResult.setText(w.getTraduzione());
    	} 
    	else {
    		txtResult.setText("Traduzione non presente nel dizionario");
    	}*/
    	

    }
    
    public boolean caretteriValidi(String s) {
    	int i;
    	boolean trovatoSpeciale=false;
    	for(i=0; i<s.length(); i++) {
    		if((s.charAt(i)>='a' && s.charAt(i)<='z')==false){
    			if(s.charAt(i)=='?' && trovatoSpeciale==false) {
    				trovatoSpeciale=true;
    			} else {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public void setModel(Dizionario model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
