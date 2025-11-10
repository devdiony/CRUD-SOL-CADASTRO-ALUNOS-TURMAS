package br.com.puc.sol;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que controla a interação com o usuário (Menu).
 * Ela não contém regras de negócio, apenas chama os métodos
 * da classe 'SistemaAcademico'.
 */
public class Main {

    private SistemaAcademico sistema;
    private Scanner scanner;

    public Main() {
        this.sistema = new SistemaAcademico();
        this.scanner = new Scanner(System.in);
        // Vamos pré-cadastrar alguns dados para facilitar os testes
        preCadastrarDados();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.executar();
    }

    public void executar() {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner
                processarOpcao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
            }
        }
        System.out.println("Sistema finalizado.");
    }

    private void exibirMenu() {
        System.out.println("\n--- Sistema de Gestão Acadêmica (SOL) ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Criar Turma");
        System.out.println("4. Matricular Aluno em Turma");
        System.out.println("5. Listar Alunos");
        System.out.println("6. Listar Professores");
        System.out.println("7. Listar Cursos");
        System.out.println("8. Listar Turmas");
        System.out.println("9. Listar Alunos de uma Turma");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAluno();
                break;
            case 2:
                cadastrarProfessor();
                break;
            case 3:
                criarTurma();
                break;
            case 4:
                matricularAlunoEmTurma();
                break;
            case 5:
                sistema.listarAlunos();
                break;
            case 6:
                sistema.listarProfessores();
                break;
            case 7:
                sistema.listarCursos();
                break;
            case 8:
                sistema.listarTurmas();
                break;
            case 9:
                listarAlunosDeTurma();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    // --- Métodos de Interação (Coleta de dados do usuário) ---

    private void cadastrarAluno() {
        System.out.println("\n-- Cadastro de Aluno --");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Matrícula: ");
        String mat = scanner.nextLine();
        System.out.print("Nome do Curso (ex: Engenharia de Software): ");
        String nomeCurso = scanner.nextLine();

        sistema.cadastrarAluno(nome, cpf, mat, nomeCurso);
    }

    private void cadastrarProfessor() {
        System.out.println("\n-- Cadastro de Professor --");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Departamento (ex: Escola de Computação): ");
        String depto = scanner.nextLine();

        sistema.cadastrarProfessor(nome, cpf, depto);
    }

    private void criarTurma() {
        System.out.println("\n-- Criação de Turma --");
        System.out.print("Nome da Disciplina (ex: POO): ");
        String nomeDisc = scanner.nextLine();
        System.out.print("CPF do Professor: ");
        String cpfProf = scanner.nextLine();
        System.out.print("Semestre (ex: 2025/2): ");
        String semestre = scanner.nextLine();

        sistema.criarTurma(nomeDisc, cpfProf, semestre);
    }

    private void matricularAlunoEmTurma() {
        System.out.println("\n-- Matricular Aluno --");
        System.out.print("Matrícula do Aluno: ");
        String matAluno = scanner.nextLine();
        System.out.print("Nome da Disciplina (ex: POO): ");
        String nomeDisc = scanner.nextLine();
        System.out.print("Semestre da Turma (ex: 2025/2): ");
        String semestre = scanner.nextLine();

        sistema.matricularAlunoEmTurma(matAluno, nomeDisc, semestre);
    }

    private void listarAlunosDeTurma() {
        System.out.println("\n-- Listar Alunos da Turma --");
        System.out.print("Nome da Disciplina (ex: POO): ");
        String nomeDisc = scanner.nextLine();
        System.out.print("Semestre da Turma (ex: 2025/2): ");
        String semestre = scanner.nextLine();

        Turma t = sistema.buscarTurma(nomeDisc, semestre);
        if (t != null) {
            t.listarAlunos();
        } else {
            System.out.println("Erro: Turma não encontrada.");
        }
    }

    /**
     * Método auxiliar para popular o sistema com dados iniciais
     * para que não precisemos cadastrar tudo toda vez que rodamos o app.
     */
    private void preCadastrarDados() {
        System.out.println("Sistema: Carregando dados iniciais...");
        sistema.cadastrarCurso("Engenharia de Software");
        sistema.cadastrarCurso("Ciência da Computação");

        sistema.cadastrarDisciplina("POO", 64);
        sistema.cadastrarDisciplina("Banco de Dados", 64);
        sistema.cadastrarDisciplina("AED", 64);

        sistema.cadastrarAluno("Diony", "111.111.111-11", "2025111", "Engenharia de Software");
        sistema.cadastrarAluno("Ana", "222.222.222-22", "2025222", "Ciência da Computação");

        sistema.cadastrarProfessor("Dr. Thalles", "333.333.333-33", "Escola de Computação");
        sistema.cadastrarProfessor("Dra. Beatriz", "444.444.444-44", "Escola de Computação");

        sistema.criarTurma("POO", "333.333.333-33", "2025/2");
        sistema.criarTurma("Banco de Dados", "444.444.444-44", "2025/2");

        sistema.matricularAlunoEmTurma("2025111", "POO", "2025/2");
        System.out.println("Sistema: Dados carregados.");
    }
}