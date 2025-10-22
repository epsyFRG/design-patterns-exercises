package emilianomassari;

import emilianomassari.adapter.*;
import emilianomassari.composite.*;
import emilianomassari.chainofresponsibility.*;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        System.out.println("=== ESERCIZI DESIGN PATTERNS ===\n");
        
        // Esercizio 1: Adapter Pattern
        System.out.println("1. ADAPTER PATTERN");
        System.out.println("==================");
        testAdapterPattern();
        
        System.out.println("\n2. COMPOSITE PATTERN");
        System.out.println("===================");
        testCompositePattern();
        
        System.out.println("\n3. CHAIN OF RESPONSIBILITY PATTERN");
        System.out.println("===================================");
        testChainOfResponsibilityPattern();
    }
    
    private static void testAdapterPattern() {
        // Creazione di un oggetto Info (incompatibile con UserData)
        Info info = new Info("Mario", "Rossi", LocalDate.of(1990, 5, 15));
        
        // Creazione dell'adapter per rendere Info compatibile con DataSource
        InfoAdapter adapter = new InfoAdapter(info);
        
        // Utilizzo di UserData con l'adapter
        UserData userData = new UserData(adapter);
        userData.stampaInfo();
    }
    
    private static void testCompositePattern() {
        // Creazione di un libro
        Libro libro = new Libro("Design Patterns", 29.99);
        libro.aggiungiAutore("Gang of Four");
        libro.aggiungiAutore("Erich Gamma");
        
        // Creazione di sezioni
        Sezione sezione1 = new Sezione("Introduzione");
        Sezione sezione2 = new Sezione("Pattern Creazionali");
        Sezione sezione3 = new Sezione("Pattern Strutturali");
        
        // Creazione di sottosezioni
        Sezione sottosezione1 = new Sezione("Singleton");
        Sezione sottosezione2 = new Sezione("Factory");
        
        // Creazione di pagine
        Pagina pagina1 = new Pagina("Prefazione", "Questo libro introduce i design patterns...");
        Pagina pagina2 = new Pagina("Cos'è un Pattern", "Un design pattern è una soluzione ricorrente...");
        Pagina pagina3 = new Pagina("Singleton Pattern", "Il Singleton garantisce una sola istanza...");
        Pagina pagina4 = new Pagina("Factory Pattern", "Il Factory crea oggetti senza specificare...");
        Pagina pagina5 = new Pagina("Adapter Pattern", "L'Adapter converte l'interfaccia di una classe...");
        
        // Composizione del libro
        libro.aggiungiElemento(pagina1);
        libro.aggiungiElemento(sezione1);
        sezione1.aggiungiElemento(pagina2);
        
        libro.aggiungiElemento(sezione2);
        sezione2.aggiungiElemento(sottosezione1);
        sezione2.aggiungiElemento(sottosezione2);
        sottosezione1.aggiungiElemento(pagina3);
        sottosezione2.aggiungiElemento(pagina4);
        
        libro.aggiungiElemento(sezione3);
        sezione3.aggiungiElemento(pagina5);
        
        // Stampa del libro
        libro.stampa(0);
    }
    
    private static void testChainOfResponsibilityPattern() {
        // Creazione della catena di responsabilità
        Tenente tenente = new Tenente();
        Capitano capitano = new Capitano();
        Maggiore maggiore = new Maggiore();
        Colonnello colonnello = new Colonnello();
        Generale generale = new Generale();
        
        // Impostazione della catena gerarchica
        tenente.setSuperiore(capitano);
        capitano.setSuperiore(maggiore);
        maggiore.setSuperiore(colonnello);
        colonnello.setSuperiore(generale);
        
        System.out.println("Gerarchia militare creata:");
        System.out.println("Tenente -> Capitano -> Maggiore -> Colonnello -> Generale\n");
        
        // Test con diversi importi
        int[] importi = {500, 1500, 2500, 3500, 4500, 5500};
        
        for (int importo : importi) {
            System.out.println("Verifica stipendio per €" + importo + ":");
            tenente.verificaStipendio(importo);
            System.out.println();
        }
    }
}
