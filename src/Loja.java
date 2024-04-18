public class Loja {

    private String nomeLoja;

    private Conta conta;

    public Loja() {

    }
    public Loja(String nomeLoja, Conta conta) {
        this.nomeLoja = nomeLoja;
        this.conta = conta;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
