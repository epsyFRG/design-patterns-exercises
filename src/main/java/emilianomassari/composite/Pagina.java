package emilianomassari.composite;

public class Pagina extends ElementoLibro {
    private String contenuto;
    
    public Pagina(String titolo, String contenuto) {
        super(titolo);
        this.contenuto = contenuto;
    }
    
    @Override
    public void stampa(int indentazione) {
        System.out.println(getIndent(indentazione) + "Pagina: " + titolo);
        System.out.println(getIndent(indentazione + 1) + "Contenuto: " + contenuto);
    }
    
    @Override
    public int getNumeroPagine() {
        return 1;
    }
    
    public String getContenuto() {
        return contenuto;
    }
}
