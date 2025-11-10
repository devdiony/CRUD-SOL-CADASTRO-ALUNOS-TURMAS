package br.com.puc.sol;

/**
 * CONCEITO: Herança.
 * A classe 'Aluno' herda da classe 'Pessoa' usando a palavra-chave 'extends'.
 * Isso significa que 'Aluno' é uma especialização de 'Pessoa' e já possui,
 * por padrão, os atributos 'nome' e 'cpf', e os métodos 'getNome()' e 'getCpf()'.
 */
public class Aluno extends Pessoa {

    /**
     * CONCEITO: Encapsulamento.
     * Estes atributos são específicos do Aluno e são 'private'.
     * O acesso a eles deve ser feito por métodos (getters/setters).
     */
    private String matricula;
    private Curso curso; // Relacionamento: Aluno ESTÁ EM um Curso

    public Aluno(String nome, String cpf, String matricula, Curso curso) {
        // Chama o construtor da classe-mãe (Pessoa) para inicializar nome e cpf
        super(nome, cpf);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * CONCEITO: Polimorfismo (Sobrescrita).
     * Usamos @Override para indicar que estamos implementando o método abstrato
     * 'exibirPerfil' que foi herdado de 'Pessoa'.
     * Esta é a implementação específica do Aluno.
     */
    @Override
    public void exibirPerfil() {
        System.out.println("--- Perfil do Aluno ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Matrícula: " + this.matricula);
        if (this.curso != null) {
            System.out.println("Curso: " + this.curso.getNome());
        }
    }
}