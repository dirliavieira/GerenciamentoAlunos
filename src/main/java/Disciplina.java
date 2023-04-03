public class Disciplina {
    private String nome;
    private Turma turma;
    private Professor professor;

    public Disciplina(String nome, Turma turma, Professor professor) {
        this.nome = nome;
        this.turma = turma;
        this.professor = professor;
    }


    public void calcularMediaDisciplina() {
        // cálculo da média da disciplina
    }

    public void calcularTaxaAprovacaoDisciplina() {
        // cálculo da taxa de aprovação da disciplina
    }

}
