package br.com.puc.sol;

/**
 * CONCEITO: Herança.
 * 'Professor' também herda de 'Pessoa', reutilizando 'nome' e 'cpf'.
 */
public class Professor extends Pessoa {

    private String departamento;
    // Poderíamos ter uma List<Turma> aqui para representar
    // as turmas que o professor leciona.

    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    /**
     * CONCEITO: Polimorfismo (Sobrescrita).
     * Esta é a implementação de 'exibirPerfil' específica para Professor.
     * Note que Aluno e Professor têm implementações diferentes
     * para o mesmo método herdado de Pessoa.
     */
    @Override
    public void exibirPerfil() {
        System.out.println("--- Perfil do Professor ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Departamento: " + this.departamento);
    }
}