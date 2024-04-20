import java.util.concurrent.locks.Lock;

public class Cliente implements Runnable {
    private String nome;
    private Conta conta;
    private Lock lock;
    private Loja loja1;
    private Loja loja2;
    private Banco banco;

    public Cliente(String nome, Conta conta, Lock lock, Loja loja1, Loja loja2, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.lock = lock;
        this.loja1 = loja1;
        this.loja2 = loja2;
        this.banco = banco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void run() {
        realizarCompras();
    }

    private void realizarCompras() {
        Loja[] lojas = {loja1, loja2};
        int indexLoja = 0;

        while (true) {
            double valorCompra = Math.random() < 0.5 ? 100.0 : 200.0;
            if (conta.getSaldo() < valorCompra) {
                break;
            }
            lock.lock();
            try {
                banco.realizarTransacao(conta, lojas[indexLoja].getConta(), valorCompra);
                System.out.println(nome + " realizou compra de R$" + valorCompra + " na loja " + lojas[indexLoja].getNomeLoja());
            } finally {
                lock.unlock();
            }

            indexLoja = (indexLoja + 1) % lojas.length;
        }
    }
}
