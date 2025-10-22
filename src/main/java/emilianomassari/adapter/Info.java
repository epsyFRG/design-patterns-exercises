package emilianomassari.adapter;

import java.time.LocalDate;
import java.time.Period;

public class Info {
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    
    public Info(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
    
    public int getEta() {
        return Period.between(dataDiNascita, LocalDate.now()).getYears();
    }
}
