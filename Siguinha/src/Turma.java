import java.util.HashMap;
import java.util.Map;

public class Turma {
    private Professor professor;

    private Disciplina materia;

    private Periodo periodo;

    private Map<Long, Aluno> alunoByDre;

    private Map<Long, Float> notaByDre;


    public Turma(Professor professor, Disciplina materia, Periodo periodo) {
        this.professor = professor;
        this.materia = materia;
        this.periodo = periodo;

        alunoByDre = new HashMap<Long, Aluno>();
    }

    public void inscreverAluno(Aluno aluno){
        Aluno alunoJaCadastrado = this.alunoByDre.get(aluno.getDre());

        if(alunoJaCadastrado!=null){
            return; //aluno ja cadastrado
        }
        this.alunoByDre.put(aluno.getDre(), aluno);
    }

    public void atribuirMediaFinal(long dre, float nota){
        Aluno aluno = this.alunoByDre.get(dre);
        Float alunoComMediaJaCadastrada = this.notaByDre.get(dre);

        if(alunoComMediaJaCadastrada!=null){
            return; //media já foi lançada
        }
        this.notaByDre.put(dre, nota);
        aluno.inserirItemHistorico(materia, nota, periodo);
    }

    public float obterMediaFinal(long dre){
        return this.notaByDre.get(dre);
    }

    public String listarAlunos(){
        String lista = new String();
        int i = 1;
        for (Aluno aluno: this.alunoByDre.values()) {
            if(aluno!=null){
                long dre = aluno.getDre();
                String nome = aluno.getNome();
                lista += String.format("Aluno %d: %s, DRE: %ld\n", i, nome, dre);
            }
        }
        return lista;
    }
}
