package emilianomassari.composite;

import java.util.ArrayList;
import java.util.List;

public class Sezione extends ElementoLibro {
    private List<ElementoLibro> elementi;
    
    public Sezione(String titolo) {
        super(titolo);
        this.elementi = new ArrayList<>();
    }
    
    public void aggiungiElemento(ElementoLibro elemento) {
        elementi.add(elemento);
    }
    
    public void rimuoviElemento(ElementoLibro elemento) {
        elementi.remove(elemento);
    }
    
    @Override
    public void stampa(int indentazione) {
        System.out.println(getIndent(indentazione) + "Sezione: " + titolo);
        for (ElementoLibro elemento : elementi) {
            elemento.stampa(indentazione + 1);
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
    
    public List<ElementoLibro> getElementi() {
        return new ArrayList<>(elementi);
    }
}
