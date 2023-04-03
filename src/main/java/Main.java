import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        int opc, qtdNotas, matricula, codigoTurma, turmaJaExiste = 0;
        String nome, nomeTurma, titulo, cpf = null;
        Aluno al;
        Turma turma = null, turmaEncontrada = null;
        ArrayList<Turma> salas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        
        do{
            linha();
            
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Excluir alunos");
            System.out.println("4 - Criar turma");
            System.out.println("5 - Listar turma");
            System.out.println("6 - Excluir turma");
            System.out.println("7 - Situações");
            System.out.println("0 - Sair");
            opc = teclado.nextInt();
            teclado.nextLine();
            System.out.println("\n");
            
            switch(opc){
                case 1:
                    linha();
                    titulo = "CADASTRAR ALUNO";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteTurma(salas)){
                        break;
                    }else{
                        System.out.println("\nNome:");
                        nome = teclado.nextLine();
                        System.out.println("\nMatrícula:");
                        matricula = teclado.nextInt();

                        al = new Aluno(nome, cpf);

                        System.out.println("\nQuantidade de notas: ");
                        qtdNotas = teclado.nextInt();

                        for (int i = 0; i < qtdNotas; i++) {
                            System.out.println("Nota " + (i + 1) + ": ");
                            al.insereNota(teclado.nextFloat());
                        }
                        
                        System.out.println("\nCódigo da turma do aluno: ");
                        codigoTurma = teclado.nextInt();
                        
                        turmaEncontrada = procuraTurma(salas, codigoTurma);
                        
                        if(turmaEncontrada != null){
                            turmaEncontrada.insereAluno(al);
                            System.out.println("\nAluno inserido!");
                        }
                    }
                    
                    break;
                case 2:
                    linha();
                    titulo = "LISTAR ALUNOS";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteTurma(salas)){
                        break;
                    }else{
                        System.out.println("\nCódigo da sala: [0 para listar todas]");
                        codigoTurma = teclado.nextInt();

                        if(codigoTurma == 0){
                            listarTodosAlunos(salas);
                        }else{
                            turmaEncontrada = procuraTurma(salas, codigoTurma);
                            
                            if(turmaEncontrada != null){
                                turmaEncontrada.listarAlunos();
                            }else{
                                System.out.println("\nTurma não encontrada!");
                            }
                        }
                    }
                    
                    break;
                case 3:
                    boolean alunoExcluido = false;
                    linha();
                    titulo = "EXCLUIR ALUNOS";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteTurma(salas)){
                        
                    }else{
                        System.out.println("Matrícula do aluno: ");
                        matricula = teclado.nextInt();
                        
                        for(Turma s:salas){
                            Aluno alunoEncontrado = s.procuraAluno(matricula);
                            
                            if(alunoEncontrado != null){
                                s.excluirAluno(alunoEncontrado);
                                alunoExcluido = true;
                            }
                        }
                        
                        if(alunoExcluido){
                            System.out.println("\nAluno excluido com sucesso!");
                        }else{
                            System.out.println("\nAluno não encontrado!");
                        }
                    }
                    
                    break;
                case 4:
                    linha();
                    titulo = "CRIAR SALA";
                    imprimirTitulo(titulo);
                    
                    System.out.println("\nCodigo: ");
                    codigoTurma = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("\nNome da turma: ");
                    nomeTurma = teclado.nextLine();
                    
                    turmaEncontrada = procuraTurma(salas, codigoTurma);
                    
                    if(turmaEncontrada != null){
                        System.out.println("Já existe uma turma com esse código");
                        break;
                    }else{
                        turma = new Turma(codigoTurma, nomeTurma);
                        salas.add(turma);
                        
                        System.out.println("\nSala criada!");
                    }
                    
                    break;
                case 5:
                    linha();
                    titulo = "LISTAR SALAS";
                    imprimirTitulo(titulo);
                    
                    listarTurma(salas);
                    
                    break;
                case 6:
                    boolean turmaExcluida = false;
                    linha();
                    titulo = "EXCLUIR TURMAS";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteTurma(salas)){
                        
                    }else{
                        System.out.println("Código da turma: ");
                        codigoTurma = teclado.nextInt();
                        teclado.nextLine();
                        
                        for(Turma s:salas){
                            turmaEncontrada = procuraTurma(salas, codigoTurma);
                            
                            if(turmaEncontrada != null){
                                turmaExcluida = true;
                            }
                        }
                        
                        if(turmaExcluida){
                            salas.remove(turmaEncontrada);
                            System.out.println("\nTurma excluída com sucesso!");
                        }else{
                            System.out.println("\nTurma não encontrada!");
                        }
                    }
                    
                    break;
                case 7:
                    linha();
                    titulo = "SITUAÇÕES";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteTurma(salas)){
                        break;
                    }else{
                        System.out.println("\nCódigo da sala: [0 para listar todas]");
                        codigoTurma = teclado.nextInt();
                        
                        if(codigoTurma == 0){
                            listarTodasSituacoes(salas);
                        }else{
                            turmaEncontrada = procuraTurma(salas, codigoTurma);
                            
                            if(turmaEncontrada != null){
                                turmaEncontrada.listarSituacoes();
                            }else{
                                System.out.println("\nTurma não encontrada!");
                            }
                        }
                    }
                    
                    break;
                case 0:
                    linha();
                    titulo = "SAINDO...";
                    imprimirTitulo(titulo);
                    
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
                    
                    break;
            }
            
        }while(opc != 0);
        
        
        
    }
    
    public static void listarSalas(ArrayList<Turma> salas){
        
        if(!naoExisteTurma(salas)){
            for(Turma s:salas){
                linha();
                System.out.println("Nome: " + s.getNome());
                System.out.println("Código: " + s.getCodigo());
            }
        }
    }
    
    public static Turma procuraTurma(ArrayList<Turma> salas, int codigoSala){
        
        for(Turma s:salas){
            if(s.getCodigo() == codigoSala){
                return s;
            }
        }
        
        return null;
    }
    
    public static void listarTodosAlunos(ArrayList<Turma> salas){
        for(Turma s:salas){
            s.listarAlunos();
        }
    }
    
    public static void listarTodasSituacoes(ArrayList<Turma> salas){
        for(Turma s:salas){
            s.listarSituacoes();
        }
    }
    
    public static boolean naoExisteTurma(ArrayList<Turma> salas){
        if(salas.isEmpty()){
            System.out.println("\nAinda não existe nenhuma turma.");
            return true;
        }else{
            return false;
        }
    }
    
    public static void linha(){
        System.out.println("\n----------------------------------------\n");
    }
    
    public static void imprimirTitulo(String titulo){
        System.out.println("\t" + titulo + "\n");
    }

    private static void listarTurma(ArrayList<Turma> salas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 	

