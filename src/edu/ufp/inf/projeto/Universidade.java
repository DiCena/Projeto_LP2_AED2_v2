package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Universidade {

    private String nome;

    private LinearProbingHashST<Integer, Aluno> alunos;

    private LinearProbingHashST<Integer, Professor> professores;

    private LinearProbingHashST<Integer, Unidade_Curricular> unidades_curriculares;

    private LinearProbingHashST<Integer, Sala> salas;

    private LinearProbingHashST<Integer, Aula> aulas;

    private LinearProbingHashST<Integer, Turma> turmas;


    public Universidade(String nome) {
        this.nome = nome;
    }

    public void remove(Aluno a) {
        if (exists(a)) {
            alunos.delete(a.getNumero());
        }
    }

    public void remove(Professor p) {
        if (exists(p)) {
            professores.delete(p.getCode());
        }
    }

    public void remove(Unidade_Curricular uc) {
        if (exists(uc)) {
            unidades_curriculares.delete(uc.getNome());
        }
    }

    public void remove(Sala s) {
        if (exists(s)) {
            salas.delete(s.getNumero());
        }
    }

    public void remove(Turma t) {
        if (exists(t)) {
            turmas.delete(t.getCodigo());
        }
    }

    public void add(Aluno a) {
        if (!exists(a)) {
            alunos.put(a.getNumero(), a);
        }
    }

    public void add(Professor p) {
        if (!exists(p)) {
            professores.put(p.getCode(), p);
        }
    }

    public void add(Unidade_Curricular uc) {
        if (!exists(uc)) {
            unidades_curriculares.put(uc.getNome(), uc);
        }
    }

    public void add(Sala s) {
        if (!exists(s)) {
            salas.put(s.getNumero(), s);
        }
    }

    public void add(Turma t) {
        if (!exists(t)) {
            turmas.put(t.getCodigo(), t);
        }
    }

    public boolean exists(Aluno a) {
        return alunos.get(a.getNumero()) == a;
    }

    public boolean exists(Professor p) {
        return professores.get(p.getCode()) == p;
    }

    public boolean exists(Unidade_Curricular uc) {
        return unidades_curriculares.get(uc.getNome()) == uc;
    }

    public boolean exists(Sala s) {
        return salas.get(s.getNumero()) == s;
    }

    public boolean exists(Turma t) {
        return turmas.get(t.getCodigo()) == t;
    }


    /**
     * Get & Sets
     */

    public LinearProbingHashST<Integer, Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(LinearProbingHashST<Integer, Aluno> alunos) {
        this.alunos = alunos;
    }

    public LinearProbingHashST<Integer, Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(LinearProbingHashST<Integer, Professor> professores) {
        this.professores = professores;
    }

    public LinearProbingHashST<Integer, Unidade_Curricular> getUnidades_curriculares() {
        return unidades_curriculares;
    }

    public void setUnidades_curriculares(LinearProbingHashST<Integer, Unidade_Curricular> unidades_curriculares) {
        this.unidades_curriculares = unidades_curriculares;
    }

    public LinearProbingHashST<Integer, Sala> getSalas() {
        return salas;
    }

    public void setSalas(LinearProbingHashST<Integer, Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "\nUniversidade{" +
                ", \nalunos=" + alunos +
                ", \nprofessores=" + professores +
                ", \nunidades_curriculares=" + unidades_curriculares +
                ", \nsalas=" + salas +
                '}';
    }

    public LinearProbingHashST<Integer, Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(LinearProbingHashST<Integer, Turma> turmas) {
        this.turmas = turmas;
    }

    public void dumpAlunos() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Alunos.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : alunos.keys()) {
                //Aluno(String nome, String email, Date data_nascimento, String morada, int numero)
                pw.println(alunos.get(key).getNome() + ";" + alunos.get(key).getEmail() + ";" + alunos.get(key).getData_nascimento() + ";"
                        + alunos.get(key).getMorada() + ";" + alunos.get(key).getNumero());
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readFileAlunos() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/Alunos.txt");
        Integer id = 0;
        if (alunos == null){
            alunos = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0];
            String email = texto[1];
            String data_nascimento = texto[2];
            String morada = texto[3];
            Integer numero = Integer.parseInt(texto[4]); //cast from string to integer

            Aluno aluno = new Aluno(nome,email,new Date(),morada,numero);
            alunos.put(id, aluno);
            id++;
        }
    }

    public void dumpProfessores() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Professores.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : professores.keys()) {
                //Professor(String nome, String email, Date data_nascimento, String morada, Date horario_atendimento, String code, int gabinete)
                pw.println(professores.get(key).getNome() + ";" + professores.get(key).getEmail() + ";" + professores.get(key).getData_nascimento() + ";"
                        + professores.get(key).getMorada() + ";" + professores.get(key).getHorario_atendimento() + ";"
                        + professores.get(key).getCode() + ";" + professores.get(key).getGabinete());
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readFileProfessores() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/Professores.txt");
        Integer id = 0;
        if (alunos == null){
            alunos = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0];
            String email = texto[1];
            String data_nascimento = texto[2];
            String morada = texto[3];
            String horario_atendimento = texto[4];
            String code = texto[5];
            Integer gabinete = Integer.parseInt(texto[5]); //cast from string to integer

            Professor professor = new Professor(nome, email, new Date(), morada, new Date(), code, gabinete);
            professores.put(id, professor);
            id++;
        }
    }

    public void dumpUC() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "UC.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);

            for (Integer key : unidades_curriculares.keys()) {
                //Unidade_Curricular(String nome, int creditos)
                pw.println(unidades_curriculares.get(key).getNome() + ";" + unidades_curriculares.get(key).getCreditos());
                /**for (String key1 : unidades_curriculares.get(key).getTurmas().keys()) {
                 pw.print(unidades_curriculares.get(key).getTurmas().get(key1).getAula() + ";" + unidades_curriculares.get(key).getTurmas().get(key1).getAlunos()
                 + ";" + unidades_curriculares.get(key).getTurmas().get(key1).getProfessor()  + ";" +
                 unidades_curriculares.get(key).getTurmas().get(key1).getUc()  + ";" + unidades_curriculares.get(key).getTurmas().get(key1).getCodigo());
                 pw.flush();
                 }**/
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dumpTurma() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Turmas.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : turmas.keys()) {
                //Turma(String codigo, Professor professor, String uc)
                pw.println(turmas.get(key).getCodigo() + ";" + turmas.get(key).getProfessor() + ";" + turmas.get(key).getUc());
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dumpAula() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Aulas.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : aulas.keys()) {
                //Aula(Date hora_inicio, Date hora_fim, Sala sala)
                pw.println(aulas.get(key).getHora_inicio() + ";" + aulas.get(key).getHora_fim() + ";" + aulas.get(key).getSala());
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void dumpSala() {

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Salas.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : salas.keys()) {
                //Sala(int numero, int capacidade, int numero_tomadas, int piso)
                pw.println(salas.get(key).getNumero() + ";" + salas.get(key).getCapacidade() + ";" + salas.get(key).getNumero_tomadas() + ";" +
                        salas.get(key).getPiso());
                pw.flush();
            }

        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e.toString());
        } finally {
            try {
                // Flush and close
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Universidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}