package emilianomassari.adapter;

public class UserData {
    private DataSource dataSource;
    
    public UserData(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void stampaInfo() {
        System.out.println("Nome completo: " + dataSource.getNomeCompleto());
        System.out.println("Età: " + dataSource.getEta());
    }
}
