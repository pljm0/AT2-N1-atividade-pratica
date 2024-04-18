public class Conta {
    private Double saldo;
    private String titular;

    public Conta() {

    }
    public Conta(Cliente cliente) {
        this.saldo = 1000.0;
        this.titular = cliente.getNome();
    }

    public Conta(Loja loja) {
        this.saldo = 0.0;
        this.titular = loja.getNomeLoja();
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public void debitar(double valor) {
        saldo -= valor;
    }

}
