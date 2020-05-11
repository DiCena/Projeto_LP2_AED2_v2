package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.LinearProbingHashST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

        Aluno ana = new Aluno("ana magina", "anamagina@ufp.edu.pt", new Date(10, 1996), "Rua das Tulipas", 919657482);
        Aluno pedro = new Aluno("pedro alves", "pedroalves@ufp.edu.pt", new Date(12, 2000), "Rua dos Cravos", 934328769);

        Universidade ufp = new Universidade("universidade fernando pessoa");

        Professor beatriz = new Professor("Beatriz Gomes", "bgomes@ufp.edu.pt", new Date(5, 1990), "Rua Julio Pontes", new Date(16, 30, 2), "2", 5);
        Professor rui = new Professor("Rui Moreira", "rmoreira@ufp.edu.pt", new Date(5, 1985), "Rua dos Carvalhos", new Date(14, 00, 3), "3", 5);

        Sala sala104 = new Sala(104, 80, 50, 1);
        Sala sala208 = new Sala(208, 65, 30, 2);

        Turma bhi = new Turma("bhi");
        Turma ghe = new Turma("ghe");

        Aula bhi1 = new Aula(new Date(16, 00, 2), new Date(18, 00, 2), sala104, bhi);
        Aula ghe2 = new Aula(new Date(16, 00, 3), new Date(18, 00, 3), sala104, ghe);

        Unidade_Curricular LP = new Unidade_Curricular("LP", 9);
        Unidade_Curricular AED = new Unidade_Curricular("AED", 9);

        LinearProbingHashST<Integer, Aula> aulas = new LinearProbingHashST<>();
        aulas.put(bhi1.getSala().getNumero(), bhi1);
        aulas.put(ghe2.getSala().getNumero(), ghe2);

        LinearProbingHashST<String, Turma> turmaLP = new LinearProbingHashST<>();
        turmaLP.put(bhi.getCodigo(), bhi);
        turmaLP.put(ghe.getCodigo(), ghe);

        LP.setTurmas(turmaLP);

        LinearProbingHashST<Integer, Aluno> turmaBhi = new LinearProbingHashST<>();
        turmaBhi.put(ana.getNumero(), ana);
        turmaBhi.put(pedro.getNumero(), pedro);

        bhi.setProfessor(rui);
        //ghe.setProfessor(beatriz);

        bhi.setAlunos(turmaBhi);

        LinearProbingHashST<String, Unidade_Curricular> uc = new LinearProbingHashST<>();
        uc.put(LP.getNome(), LP);
        uc.put(AED.getNome(), AED);

        LinearProbingHashST<Integer, Sala> salas = new LinearProbingHashST<>();
        salas.put(sala104.getNumero(), sala104);
        salas.put(sala208.getNumero(), sala208);

        LinearProbingHashST<String, Professor> professores = new LinearProbingHashST<>();
        professores.put(rui.getCode(), rui);
        professores.put(beatriz.getCode(), beatriz);

        LinearProbingHashST<Integer, Aluno> alunos = new LinearProbingHashST<>();
        alunos.put(ana.getNumero(), ana);
        alunos.put(pedro.getNumero(), pedro);

        ufp.setTurmas(turmaLP);
        ufp.setAulas(aulas);
        ufp.setUnidades_curriculares(uc);
        ufp.setSalas(salas);
        ufp.setProfessores(professores);
        ufp.setAlunos(alunos);

        //ufp.readFileAlunos();
        //ufp.readFileProfessores();
        //ufp.readFileAulas();
        //ufp.readFileTurma();
        //ufp.readFileUC();
        //ufp.readFileSala();

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

        LinearProbingHashST<String, Professor> Pesquisa = ufp.findAllProfessorsOfUC("LP");
        if (Pesquisa == null)
            System.out.println("Pesquisa é Nula");
        else {
            for (String key : Pesquisa.keys()) {
                //Professor(String nome, String email, Date data_nascimento, String morada, Date horario_atendimento, String code, int gabinete)
                System.out.println(Pesquisa.get(key).getNome() + ";" + Pesquisa.get(key).getEmail() + ";" + Pesquisa.get(key).getData_nascimento() + ";"
                        + Pesquisa.get(key).getMorada() + ";" + Pesquisa.get(key).getHorario_atendimento()
                        + ";" + Pesquisa.get(key).getCode() + ";" + Pesquisa.get(key).getGabinete());
            }
        }

        LinearProbingHashST<Integer, Sala> PesquisaSala = ufp.findAllRoomByFloor(1);
        LinearProbingHashST<Integer, Sala> PesquisaSala1 = ufp.findAllRoomByPowerSockets(40);
        LinearProbingHashST<Integer, Sala> PesquisaSala2 = ufp.findAllRoomBySizBiggerThan(70);
        System.out.println("Pesquisa por piso:");
        for (Integer key : PesquisaSala.keys()) {

            System.out.println(PesquisaSala.get(key).getNumero() + ";" + PesquisaSala.get(key).getCapacidade() + ";" + PesquisaSala.get(key).getNumero_tomadas() + ";"
                    + PesquisaSala.get(key).getPiso());
        }
        System.out.println("Pesquisa por tomadas:");
        for (Integer key : PesquisaSala1.keys()) {

            System.out.println(PesquisaSala1.get(key).getNumero() + ";" + PesquisaSala1.get(key).getCapacidade() + ";" + PesquisaSala1.get(key).getNumero_tomadas() + ";"
                    + PesquisaSala1.get(key).getPiso());
        }
        System.out.println("Pesquisa por capacidade:");
        for (Integer key : PesquisaSala2.keys()) {

            System.out.println(PesquisaSala2.get(key).getNumero() + ";" + PesquisaSala2.get(key).getCapacidade() + ";" + PesquisaSala2.get(key).getNumero_tomadas() + ";"
                    + PesquisaSala2.get(key).getPiso());
        }

        LinearProbingHashST<Integer,Sala> pesquisaSalas = ufp.salasLivres(new Date(16, 00, 2));
        for (Integer key : pesquisaSalas.keys()) {

            System.out.println("Sala numero: " + pesquisaSalas.get(key).getNumero() + "\n\tCapacidade: " + pesquisaSalas.get(key).getCapacidade() +
                    "\n\tNumero de tomadas: " + pesquisaSalas.get(key).getNumero_tomadas() + "\n\tPiso: "
                    + pesquisaSalas.get(key).getPiso());
        }

    }
}
