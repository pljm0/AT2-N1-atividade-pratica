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

    public synchronized void pagarSalarios() {
        double valorSalario = 1400.0;
        if (conta.getSaldo() >= valorSalario * 2) {
            conta.debitar(valorSalario * 2);
        }
    }

    public synchronized void realizarCompra(double valor) {
        conta.debitar(valor);
        System.out.println("Compra de R$" + valor + " realizada na loja " + nomeLoja);
    }
}
