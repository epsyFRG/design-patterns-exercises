package emilianomassari.composite;

public abstract class ElementoLibro {
    protected String titolo;

    public ElementoLibro(String titolo) {
        this.titolo = titolo;
    }

    public abstract void stampa(int indentazione);

    public abstract int getNumeroPagine();

    protected String getIndent(int livello) {
        return "  ".repeat(livello);
    }
}