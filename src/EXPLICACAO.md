Explicação do Funcionamento e Conceitos de POO

Este documento detalha como o sistema de gestão acadêmica (SOL) foi estruturado e como os princípios da Programação Orientada a Objetos (POO) foram aplicados, conforme solicitado na atividade.

Funcionamento do Sistema

O sistema é dividido em duas camadas principais:

Camada de Interação (Pacote br.com.puc.sol, Classe Main):

Responsável por interagir com o usuário via console.

Exibe o menu de opções (exibirMenu()).

Coleta os dados de entrada do usuário (usando Scanner).

Não contém nenhuma regra de negócio. Ela apenas "chama" a camada de serviço.

Camada de Serviço e Domínio (Pacote br.com.puc.sol):

Classes de Entidade: Pessoa, Aluno, Professor, Curso, Disciplina, Turma. Elas representam os "objetos" do mundo real e seus relacionamentos.

Classe de Gerenciamento (SistemaAcademico): Esta classe funciona como uma "fachada" (Facade). Ela centraliza toda a lógica de negócio e as operações de CRUD. Ela gerencia as listas (ArrayLists) que simulam o banco de dados em memória, garantindo que a Main não precise saber como os dados são armazenados.

Aplicação dos 4 Pilares da POO

Este projeto foi estruturado com base nos 4 pilares da POO:

1. Abstração

O conceito de Abstração foi aplicado na criação da classe Pessoa.

Por quê? No sistema, nunca iremos cadastrar uma "Pessoa" genérica. Nós cadastramos Aluno ou Professor.

Como? A classe Pessoa foi declarada como abstract. Ela serve como um "molde" ou "conceito" que define o que todas as suas subclasses devem ter em comum (como nome e cpf).

Método Abstrato: Ela também define o método abstrato public abstract void exibirPerfil();. Isso força que toda classe filha (como Aluno) seja obrigada a fornecer uma implementação concreta para este método.

2. Herança

A Herança é usada para reutilização de código e para estabelecer uma hierarquia clara.

Como? As classes Aluno e Professor usam a palavra-chave extends Pessoa.

Benefício: Elas herdam automaticamente os atributos (nome, cpf) e métodos (getNome(), getCpf()) da classe Pessoa, evitando a duplicação de código. Isso estabelece uma relação "é-um-tipo-de" (um Aluno "é-um-tipo-de" Pessoa).

3. Encapsulamento

O Encapsulamento é aplicado em todas as classes do sistema para proteger a integridade dos dados.

Como? Todos os atributos (campos) das classes são declarados como private (ex: matricula em Aluno) ou protected (ex: nome em Pessoa).

Benefício: Isso impede que uma classe externa (como a Main) acesse ou modifique diretamente os dados. Por exemplo, a Main não pode fazer aluno.matricula = "novoValor".

Acesso Controlado: O acesso é feito de forma controlada através de métodos públicos (getters e setters), como aluno.getMatricula(). Na classe SistemaAcademico, as listas que simulam o banco de dados são private, e a única forma de interagir com elas é através dos métodos públicos (cadastrarAluno(), listarAlunos()), que contêm a lógica de negócio.

4. Polimorfismo

O Polimorfismo (neste caso, por sobrescrita) é um dos conceitos centrais da atividade.

Definição: O método exibirPerfil() foi definido como abstract na classe-mãe Pessoa.

Implementação: As classes filhas Aluno e Professor implementam (@Override) suas próprias versões específicas deste método. O Aluno exibe a matrícula e o curso, enquanto o Professor exibe o departamento.

Execução Polimórfica: Embora tenhamos listado Alunos e Professores em métodos separados (listarAlunos(), listarProfessores()), poderíamos facilmente demonstrar o polimorfismo criando uma lista de List<Pessoa>. Se percorrêssemos essa lista e chamássemos pessoa.exibirPerfil(), o Java (em tempo de execução) saberia exatamente qual versão do método executar (a do Aluno ou a do Professor) com base no tipo real do objeto, permitindo tratar objetos diferentes de forma uniforme.