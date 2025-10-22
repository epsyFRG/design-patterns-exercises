package emilianomassari.chainofresponsibility;

public abstract class Ufficiale {
    protected Ufficiale superiore;
    protected String grado;
    protected int stipendio;
    protected String funzione;

    public Ufficiale(String grado, int stipendio, String funzione) {
        this.grado = grado;
        this.stipendio = stipendio;
        this.funzione = funzione;
    }

    public void setSuperiore(Ufficiale superiore) {
        this.superiore = superiore;
    }

    public void verificaStipendio(int importo) {
        if (stipendio >= importo) {
            System.out.println("Il " + grado + " percepisce almeno €" + importo);
            System.out.println("Stipendio: €" + stipendio);
            System.out.println("Funzione: " + funzione);
        } else if (superiore != null) {
            superiore.verificaStipendio(importo);
        } else {
            System.out.println("Nessun ufficiale percepisce almeno €" + importo);
        }
    }

    public String getGrado() {
        return grado;
    }

    public int getStipendio() {
        return stipendio;
    }

    public String getFunzione() {
        return funzione;
    }

    public void stampaInfo() {
        System.out.println(grado + " - Stipendio: €" + stipendio + " - Funzione: " + funzione);
    }
}