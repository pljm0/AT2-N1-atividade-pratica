public class Funcionario implements Runnable {
    private String nome;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String nome, Loja loja, Conta contaSalario, Conta contaInvestimento) {
        this.nome = nome;
        this.loja = loja;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    @Override
    public void run() {
        double salario = 1400.0;
        loja.pagarSalarios();
        contaSalario.creditar(salario);
        double valorInvestimento = salario * 0.20;
        contaInvestimento.creditar(valorInvestimento);
        contaSalario.debitar(valorInvestimento);
        System.out.println(nome + " recebeu o salário e investiu R$" + valorInvestimento);
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }
}
