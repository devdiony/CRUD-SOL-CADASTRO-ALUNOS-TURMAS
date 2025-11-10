Atividade Prática: Sistema de Gestão Acadêmica (SOL)

Este projeto é uma simulação em Java de um sistema de gestão acadêmica, inspirado no SOL da PUC Goiás. O sistema foi desenvolvido como atividade da disciplina de Análise e Desenvolvimento de Sistemas, aplicando os conceitos fundamentais da Programação Orientada a Objetos (POO).

O sistema é executado via console e armazena os dados em memória (utilizando ArrayLists), permitindo operações de cadastro e consulta (CRUD).

1. Diagrama de Classes UML

O Diagrama de Classes UML completo, representando a arquitetura do sistema, pode ser encontrado no link abaixo:

![Diagrama UML do Sistema SOL](DiagramaUML.jpg)

2. Documentação e Conceitos de POO

Uma explicação detalhada sobre o funcionamento do sistema e como os pilares da POO (Abstração, Herança, Encapsulamento e Polimorfismo) foram aplicados está disponível no documento:

EXPLICACAO_POO.md

3. Funcionalidades e CRUD

O sistema é controlado pela classe Main.java, que exibe um menu de console. Todas as operações de negócio são delegadas à classe SistemaAcademico, que gerencia as listas de dados em memória, implementando as operações de CRUD (Create, Read, Update, Delete) solicitadas:

Create (Criar): cadastrarAluno(), cadastrarProfessor(), cadastrarCurso(), criarTurma().

Read (Ler): listarAlunos(), listarProfessores(), listarCursos(), listarTurmas(), listarAlunosDeTurma().

Update (Atualizar): matricularAlunoEmTurma() (que atualiza a lista de alunos de uma turma).

Delete (Remover): O método removerAluno() na classe Turma demonstra essa funcionalidade (acessível via Turma.removerAluno()).

4. Como Executar

Clone este repositório.

Abra o projeto em uma IDE Java (ex: IntelliJ ou Eclipse).

Execute o arquivo Main.java (localizado em br/com/puc/sol/Main.java).

O sistema carregará dados pré-cadastrados (cursos, alunos, professores, turmas).

Utilize o menu numérico no console para interagir com o sistema.
