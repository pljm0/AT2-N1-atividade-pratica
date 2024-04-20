import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Lock lock = new ReentrantLock();

        Loja loja1 = new Loja("Loja A", new Conta("Loja A"));
        Loja loja2 = new Loja("Loja B", new Conta("Loja B"));

        Cliente cliente1 = new Cliente("Cliente 1", new Conta("Cliente 1"), lock, loja1, loja2, banco);
        Cliente cliente2 = new Cliente("Cliente 2", new Conta("Cliente 2"), lock, loja1, loja2, banco);
        Cliente cliente3 = new Cliente("Cliente 3", new Conta("Cliente 3"), lock, loja1, loja2, banco);
        Cliente cliente4 = new Cliente("Cliente 4", new Conta("Cliente 4"), lock, loja1, loja2, banco);
        Cliente cliente5 = new Cliente("Cliente 5", new Conta("Cliente 5"), lock, loja1, loja2, banco);

        Thread threadCliente1 = new Thread(cliente1);
        Thread threadCliente2 = new Thread(cliente2);
        Thread threadCliente3 = new Thread(cliente3);
        Thread threadCliente4 = new Thread(cliente4);
        Thread threadCliente5 = new Thread(cliente5);

        threadCliente1.start();
        threadCliente2.start();
        threadCliente3.start();
        threadCliente4.start();
        threadCliente5.start();

        Funcionario funcionario1 = new Funcionario("Funcionário 1", loja1, new Conta("Funcionário 1 Salário"), new Conta("Funcionário 1 Investimento"));
        Funcionario funcionario2 = new Funcionario("Funcionário 2", loja1, new Conta("Funcionário 2 Salário"), new Conta("Funcionário 2 Investimento"));
        Funcionario funcionario3 = new Funcionario("Funcionário 3", loja2, new Conta("Funcionário 3 Salário"), new Conta("Funcionário 3 Investimento"));
        Funcionario funcionario4 = new Funcionario("Funcionário 4", loja2, new Conta("Funcionário 4 Salário"), new Conta("Funcionário 4 Investimento"));

        Thread threadFuncionario1 = new Thread(funcionario1);
        Thread threadFuncionario2 = new Thread(funcionario2);
        Thread threadFuncionario3 = new Thread(funcionario3);
        Thread threadFuncionario4 = new Thread(funcionario4);

        threadFuncionario1.start();
        threadFuncionario2.start();
        threadFuncionario3.start();
        threadFuncionario4.start();

        try {
            threadCliente1.join();
            threadCliente2.join();
            threadCliente3.join();
            threadCliente4.join();
            threadCliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            threadFuncionario1.join();
            threadFuncionario2.join();
            threadFuncionario3.join();
            threadFuncionario4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldos finais das contas:");
        System.out.println("Conta do Cliente 1: " + cliente1.getConta().getSaldo());
        System.out.println("Conta do Cliente 2: " + cliente2.getConta().getSaldo());
        System.out.println("Conta do Cliente 3: " + cliente3.getConta().getSaldo());
        System.out.println("Conta do Cliente 4: " + cliente4.getConta().getSaldo());
        System.out.println("Conta do Cliente 5: " + cliente5.getConta().getSaldo());
        System.out.println("Conta do Funcionário 1: " + funcionario1.getContaSalario().getSaldo());
        System.out.println("Conta do Funcionário 2: " + funcionario2.getContaSalario().getSaldo());
        System.out.println("Conta do Funcionário 3: " + funcionario3.getContaSalario().getSaldo());
        System.out.println("Conta do Funcionário 4: " + funcionario4.getContaSalario().getSaldo());
    }
}
