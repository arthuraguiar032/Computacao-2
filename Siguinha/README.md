# Siguinha
O Siguinha é um projeto de gerenciador acadêmico que tem como objetivo auxiliar na organização e manipulação de informações relacionadas a alunos, turmas, professores e notas.

### Funcionalidades Implementas nesse Projeto ###
1. Na classe Siguinha, acrescenta uma estrutura para armazenar alunos. (Sugestão: use HashMap)

2. Implemente na classe Siguinha um método
    ```
    void cadastrarAluno(long dre, String nome)
    ```
3. Implemente tb na classe Siguinha um método 
    ```
    Aluno obterAluno(long dre)
    ```
4. Crie uma classe Pessoa com atributos nome e ano de nascimento.

5. Faça com que Aluno herde de Pessoa, eliminando de Aluno atributos e métodos redundantes.

6. Crie uma classe Professor, herdando de Pessoa e acrescentando anoContratacao.

7. Crie uma classe Turma. Um objeto da classe Turma representará uma disciplina em um determinado período lecionada por um determinado professor. A classe Turma deve ter os seguintes métodos públicos:
    ```
    void inscreverAluno(Aluno aluno)
    void atribuirMediaFinal(long dre, float nota)
    float obterMediaFinal(long dre)
    String listarAlunos()
    ```
