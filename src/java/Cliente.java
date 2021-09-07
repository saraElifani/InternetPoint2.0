public class Cliente {
    private String nome;
    private String cognome;
    private String oraInizio;
    private String oraFine;

    public Cliente(String nome, String cognome, String oraInizio) {
        this.nome = nome;
        this.cognome = cognome;
        this.oraInizio = oraInizio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", oraInizio='" + oraInizio + '\'' +
                ", oraFine='" + oraFine + '\'' +
                '}';
    }
}
