public class Conta {
    private Double saldo;
    private String titular;

    public Conta() {

    }
    public Conta(String Titular) {
        this.saldo = 0.0;
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo != null ? saldo : 0.0;
    }

    public void creditar(double valor) {
        if (saldo == null) {
            saldo = 0.0;
        }
        saldo += valor;
    }

    public void debitar(double valor) {
        if (saldo == null) {
            saldo = 0.0;
        }
        saldo -= valor;
    }
}
