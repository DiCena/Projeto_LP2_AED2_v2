package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.LinearProbingHashST;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {

	    Aluno ana = new Aluno("ana magina", "anamagina@ufp.edu.pt", new Date(10,1996), "Rua das Tulipas", 919657482);
        Aluno pedro = new Aluno("pedro alves", "pedroalves@ufp.edu.pt", new Date(12,2000), "Rua dos Cravos", 934328769);

        Universidade ufp = new Universidade("universidade fernando pessoa");

        Professor beatriz = new Professor("Beatriz Gomes", "bgomes@ufp.edu.pt" , new Date(5,1990), "Rua Julio Pontes", new Date(16,30,2),"2", 5);
        Professor rui = new Professor("Rui Moreira", "rmoreira@ufp.edu.pt" , new Date(5,1985), "Rua dos Carvalhos", new Date(14,00,3), "3",5);

        Sala sala104 = new Sala(5, 80, 5, 1);

        Aula bhi1 = new Aula(new Date(16,00,2), new Date(18,00,2));
        Aula ghe2 = new Aula (new Date(16,00,3), new Date(18,00,3));

        Turma bhi = new Turma("bhi");
        Turma ghe = new Turma("ghe");

        Unidade_Curricular LP = new Unidade_Curricular("LP", 9);
        Unidade_Curricular AED = new Unidade_Curricular("AED", 9);

        LinearProbingHashST<Integer,Aula> aulas = new LinearProbingHashST<>();
        aulas.put(0 ,bhi1);

        LinearProbingHashST<String,Turma> turmaLP = new LinearProbingHashST<>();
        turmaLP.put("bhi",bhi);
        turmaLP.put("ghe",ghe);

        LP.setTurmas(turmaLP);

        LinearProbingHashST<Integer,Aluno> turmaBhi = new LinearProbingHashST<>();
        turmaBhi.put(0,ana);
        turmaBhi.put(1,pedro);

        bhi.setAlunos(turmaBhi);

        LinearProbingHashST<String,Unidade_Curricular> uc = new LinearProbingHashST<>();
        uc.put("0", LP);
        uc.put("1", AED);

        LinearProbingHashST<Integer, Sala> salas = new LinearProbingHashST<>();
        salas.put(1,sala104);

        LinearProbingHashST<String,Professor> professores = new LinearProbingHashST<>();
        professores.put("0",rui);
        professores.put("1",beatriz);

        LinearProbingHashST<Integer, Aluno> alunos = new LinearProbingHashST<>();
        alunos.put(0,ana);
        alunos.put(1,pedro);

        //ufp.setTurmas(turmaLP);
        //ufp.setAulas(aulas);
        //ufp.setUnidades_curriculares(uc);
        //ufp.setSalas(salas);
        //ufp.setProfessores(professores);
        //ufp.setAlunos(alunos);

        ufp.readFileAlunos();
        ufp.readFileProfessores();
        ufp.readFileAulas();
        ufp.readFileTurma();
        ufp.readFileUC();
        ufp.readFileSala();

        //System.out.println(ufp.toString());

        ufp.dumpAlunos();
        ufp.dumpProfessores();
        ufp.dumpUC();
        ufp.dumpTurma();
        ufp.dumpAula();
        ufp.dumpSala();

        ufp.printLinearProbingPrintAlunos();
        ufp.printLinearProbingPrintProfessor();
        ufp.printLinearProbingPrintTurma();
        ufp.printLinearProbingPrintAula();
        ufp.printLinearProbingPrintUC();
        ufp.printLinearProbingPrintSala();

    }
}
