public class Banco {
    public synchronized void realizarTransacao(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transação de R$" + valor + " realizada de " + origem.getTitular() + " para " + destino.getTitular());
        } else {
            System.out.println("Saldo insuficiente em " + origem.getTitular() + " para realizar a transação.");
        }
    }
}
