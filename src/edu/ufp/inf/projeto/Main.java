package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.RedBlackBST;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {

	    Aluno ana = new Aluno("ana magina", "anamagina@ufp.edu.pt", new Date(10,1996), "Rua das Tulipas", 919657482);
        Aluno pedro = new Aluno("pedro alves", "pedroalves@ufp.edu.pt", new Date(12,2000), "Rua dos Cravos", 934328769);

        Universidade ufp = new Universidade("universidade fernando pessoa");

        Professor beatriz = new Professor("Beatriz Gomes", "bgomes@ufp.edu.pt" , new Date(5,1990), "Rua Julio Pontes", new Date(16,30,2), 5);
        Professor rui = new Professor("Rui Moreira", "rmoreira@ufp.edu.pt" , new Date(5,1985), "Rua dos Carvalhos", new Date(14,00,3), 5);

        Sala Sala104 = new Sala(5, 80, 5, 1);

        Turma bhi = new Turma("bhi", new Date(16,00,2), new Date(18,00,2), rui, Sala104);
        Turma ghe = new Turma("ghe", new Date(16,00,3), new Date(18,00,3), beatriz, Sala104);

        Unidade_Curricular LP = new Unidade_Curricular("LP", 9);
        Unidade_Curricular AED = new Unidade_Curricular("AED", 9);

        ArrayList<Turma> turmaLP = new ArrayList<>();
        turmaLP.add(bhi);
        turmaLP.add(ghe);

        LP.setTurmas(turmaLP);

        ArrayList<Aluno> turmaBhi = new ArrayList<>();
        turmaBhi.add(ana);
        turmaBhi.add(pedro);

        bhi.setAlunos(turmaBhi);

        ArrayList<Unidade_Curricular> uc = new ArrayList<>();
        uc.add(LP);
        uc.add(AED);

        ArrayList<Sala> salas = new ArrayList<>();
        salas.add(Sala104);

        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(rui);
        professores.add(beatriz);

        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(ana);
        alunos.add(pedro);

        ufp.setUnidades_curriculares(uc);
        ufp.setSalas(salas);
        ufp.setProfessores(professores);
        ufp.setAlunos(alunos);

        System.out.println(ufp.toString());

    }
}
