package br.com.puc.sol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe principal de gerenciamento (Facade).
 * Ela centraliza todas as operações de CRUD (Create, Read, Update, Delete)
 * e gerencia as listas de dados em memória.
 * Isso demonstra a Separação de Responsabilidades: Main cuida do Menu,
 * e SistemaAcademico cuida das regras de negócio.
 */
public class SistemaAcademico {

    // Listas para armazenamento em memória (simulando um BD)
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Turma> turmas;

    public SistemaAcademico() {
        this.cursos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    // --- MÉTODOS DE CADASTRO (CREATE) ---

    public void cadastrarCurso(String nome) {
        this.cursos.add(new Curso(nome));
        System.out.println("Curso " + nome + " cadastrado.");
    }

    public void cadastrarDisciplina(String nome, int carga) {
        this.disciplinas.add(new Disciplina(nome, carga));
        System.out.println("Disciplina " + nome + " cadastrada.");
    }

    public void cadastrarAluno(String nome, String cpf, String matricula, String nomeCurso) {
        Curso curso = buscarCursoPorNome(nomeCurso);
        if (curso == null) {
            System.out.println("Erro: Curso " + nomeCurso + " não encontrado.");
            return;
        }
        this.alunos.add(new Aluno(nome, cpf, matricula, curso));
        System.out.println("Aluno " + nome + " cadastrado.");
    }

    public void cadastrarProfessor(String nome, String cpf, String depto) {
        this.professores.add(new Professor(nome, cpf, depto));
        System.out.println("Professor " + nome + " cadastrado.");
    }

    public void criarTurma(String nomeDisciplina, String cpfProfessor, String semestre) {
        Disciplina disc = buscarDisciplinaPorNome(nomeDisciplina);
        Professor prof = buscarProfessorPorCpf(cpfProfessor);

        if (disc == null) {
            System.out.println("Erro: Disciplina " + nomeDisciplina + " não encontrada.");
            return;
        }
        if (prof == null) {
            System.out.println("Erro: Professor com CPF " + cpfProfessor + " não encontrado.");
            return;
        }

        this.turmas.add(new Turma(disc, prof, semestre));
        System.out.println("Turma de " + disc.getNome() + " criada para o semestre " + semestre);
    }

    // --- MÉTODOS DE CONSULTA (READ) ---

    public void listarCursos() {
        System.out.println("\n--- Lista de Cursos ---");
        for (Curso c : this.cursos) {
            System.out.println(c.getNome());
        }
    }

    public void listarAlunos() {
        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno a : this.alunos) {
            a.exibirPerfil(); // Polimorfismo sendo usado (embora todos sejam Alunos aqui)
        }
    }

    public void listarProfessores() {
        System.out.println("\n--- Lista de Professores ---");
        for (Professor p : this.professores) {
            p.exibirPerfil(); // Polimorfismo sendo usado
        }
    }

    public void listarTurmas() {
        System.out.println("\n--- Lista de Turmas ---");
        for (Turma t : this.turmas) {
            System.out.println("Turma: " + t.getDisciplina().getNome() + " (" + t.getSemestre() + ")");
            System.out.println("  Professor: " + t.getProfessor().getNome());
        }
    }

    // --- MÉTODOS DE RELACIONAMENTO (UPDATE) ---

    public void matricularAlunoEmTurma(String matriculaAluno, String nomeDisciplina, String semestre) {
        Aluno aluno = buscarAlunoPorMatricula(matriculaAluno);
        Turma turma = buscarTurma(nomeDisciplina, semestre);

        if (aluno == null) {
            System.out.println("Erro: Aluno com matrícula " + matriculaAluno + " não encontrado.");
            return;
        }
        if (turma == null) {
            System.out.println("Erro: Turma " + nomeDisciplina + "/" + semestre + " não encontrada.");
            return;
        }

        turma.adicionarAluno(aluno);
    }

    // --- MÉTODOS AUXILIARES (Busca) ---

    // O uso do 'Optional' é uma prática moderna para evitar 'null'
    // Mas para simplicidade do CRUD, vamos retornar 'null' se não achar.

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : this.alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public Professor buscarProfessorPorCpf(String cpf) {
        for (Professor p : this.professores) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public Curso buscarCursoPorNome(String nome) {
        for (Curso c : this.cursos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Disciplina buscarDisciplinaPorNome(String nome) {
        for (Disciplina d : this.disciplinas) {
            if (d.getNome().equalsIgnoreCase(nome)) {
                return d;
            }
        }
        return null;
    }

    public Turma buscarTurma(String nomeDisciplina, String semestre) {
        for (Turma t : this.turmas) {
            if (t.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplina) &&
                    t.getSemestre().equals(semestre)) {
                return t;
            }
        }
        return null;
    }
}