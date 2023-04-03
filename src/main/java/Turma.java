import java.util.ArrayList;

public class Turma {
    int codigo;
    String nome;
    ArrayList<Aluno> alunos = new ArrayList<>();

    Turma(int codigoTurma, String nomeTurma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Sala(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public void insereAluno(Aluno al){
        this.alunos.add(al);
    }
    
    public void excluirAluno(Aluno al){
        alunos.remove(al);
    }
    
    public void listarAlunos(){
        if(turmaVazia()){
            
        }else{
            for(Aluno a:alunos){
                int i = 1;
                System.out.println("Nome: " + a.getNome());
                System.out.println("Matrícula: " + a.getMatricula());
                System.out.println("Sala: " + this.getCodigo());

                for(Float n:a.notasAluno){
                    System.out.println("Nota " + i + ": " + n);
                    i++;
                }

                System.out.println("Total: " + a.total);
            }
        }
    }
    
    public void listarSituacoes(){
        if(turmaVazia()){
            
        }else{
            for(Aluno a:alunos){
                int i = 1;
                System.out.println("Nome: " + a.getNome());
                System.out.println("Turma: " + codigo);
                System.out.println("Total: " + a.total);
                System.out.println("Situação: " + a.situacao);
            }
        }
    }
    
    public boolean turmaVazia(){
        if(alunos.isEmpty()){
            System.out.println("\nNenhum aluno na turma " + this.codigo);
            return true;
        }else
            return false;
    }
    
    public Aluno procuraAluno(String matricula){
        
        for(Aluno a:alunos){
            if(a.getMatricula().equals(matricula)){
                return a;
            }
        }
        
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    Aluno procuraAluno(int matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /** public double calcularMediaTurma() {
        // cálculo da média da turma
    }

    public double calcularTaxaAprovacao() {
        // cálculo da taxa de aprovação da turma
    } **/

}

