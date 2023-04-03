import java.util.ArrayList;

public class Aluno {
    String nome, matricula, situacao = "REPROVADO";
    float total;
    ArrayList<Float> notasAluno = new ArrayList<>();
    
    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public void insereNota(float nota){
        this.notasAluno.add(nota);
        calculaNotas(notasAluno);
    }
    
    public void calculaNotas(ArrayList<Float> notasAluno){
        total = 0;
        
        for(Float n:notasAluno){
            total += n;
        }
        
        if(total <= 7){
            situacao = "REPROVADO";
        }else{
            situacao = "APROVADO";
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList getNotasAluno() {
        return notasAluno;
    }

    public void setNotasAluno(ArrayList notasAluno) {
        this.notasAluno = notasAluno;
    }
    
}
