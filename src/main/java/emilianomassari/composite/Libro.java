package emilianomassari.composite;

import java.util.ArrayList;
import java.util.List;

public class Libro extends ElementoLibro {
    private List<String> autori;
    private double prezzo;
    private List<ElementoLibro> elementi;
    
    public Libro(String titolo, double prezzo) {
        super(titolo);
        this.prezzo = prezzo;
        this.autori = new ArrayList<>();
        this.elementi = new ArrayList<>();
    }
    
    public void aggiungiAutore(String autore) {
        autori.add(autore);
    }
    
    public void aggiungiElemento(ElementoLibro elemento) {
        elementi.add(elemento);
    }
    
    public void rimuoviElemento(ElementoLibro elemento) {
        elementi.remove(elemento);
    }
    
    @Override
    public void stampa(int indentazione) {
        System.out.println(getIndent(indentazione) + "Libro: " + titolo);
        System.out.println(getIndent(indentazione + 1) + "Autori: " + String.join(", ", autori));
        System.out.println(getIndent(indentazione + 1) + "Prezzo: €" + prezzo);
        System.out.println(getIndent(indentazione + 1) + "Numero totale pagine: " + getNumeroPagine());
        System.out.println(getIndent(indentazione + 1) + "Contenuto:");
        for (ElementoLibro elemento : elementi) {
            elemento.stampa(indentazione + 2);
        }
    }
    
    @Override
    public int getNumeroPagine() {
        int totale = 0;
        for (ElementoLibro elemento : elementi) {
            totale += elemento.getNumeroPagine();
        }
        return totale;
    }
    
    public List<String> getAutori() {
        return new ArrayList<>(autori);
    }
    
    public double getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
    public List<ElementoLibro> getElementi() {
        return new ArrayList<>(elementi);
    }
}
