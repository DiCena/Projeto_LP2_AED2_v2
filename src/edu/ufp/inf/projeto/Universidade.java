package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Universidade {

    private String nome;

    private LinearProbingHashST<Integer, Aluno> alunos;

    private LinearProbingHashST<String, Professor> professores;

    private LinearProbingHashST<String, Unidade_Curricular> unidades_curriculares;

    private LinearProbingHashST<Integer, Sala> salas;

    private LinearProbingHashST<Integer, Aula> aulas;

    private LinearProbingHashST<String, Turma> turmas;

    private ArrayList<Object> deleted;


    public Universidade(String nome) {
        this.nome = nome;
    }

    public void remove(Aluno a) {
        if (exists(a)) {
            for (String si:a.getTurmas().keys()) {
                a.getTurmas().get(si).getAlunos().delete(a.getNumero());
            }
            alunos.delete(a.getNumero());
            deleted.add(a);
        }
    }

    public void remove(Professor p) {
        if (exists(p)) {
            for (String si:p.getTurmas().keys()) {
                p.getTurmas().get(si).setProfessor(null);
            }
            professores.delete(p.getCode());
            deleted.add(p);
        }
    }

    public void remove(Unidade_Curricular uc) {
        if (exists(uc)) {
            for (String si:uc.getTurmas().keys()) {
                deleted.add(uc.getTurmas().get(si));
                uc.getTurmas().get(si).safeDelete();
            }
            unidades_curriculares.delete(uc.getNome());
            deleted.add(uc);
        }
    }

    public void remove(Sala s) {
        if (exists(s)) {
            for (Date di:s.getHorario().keys()) {
                deleted.add(s.getHorario().get(di));
                s.getHorario().get(di).getTurma().setAula(null);
            }
            salas.delete(s.getNumero());
            deleted.add(s);
        }
    }

    public void remove(Turma t) {
        if (exists(t)) {
            t.safeDelete();
            turmas.delete(t.getCodigo());
            deleted.add(t);
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

    public LinearProbingHashST<String, Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(LinearProbingHashST<String, Professor> professores) {
        this.professores = professores;
    }

    public LinearProbingHashST<String, Unidade_Curricular> getUnidades_curriculares() {
        return unidades_curriculares;
    }

    public void setUnidades_curriculares(LinearProbingHashST<String, Unidade_Curricular> unidades_curriculares) {
        this.unidades_curriculares = unidades_curriculares;
    }

    public LinearProbingHashST<Integer, Sala> getSalas() {
        return salas;
    }

    public void setSalas(LinearProbingHashST<Integer, Sala> salas) {
        this.salas = salas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinearProbingHashST<Integer, Aula> getAulas() {
        return aulas;
    }

    public void setAulas(LinearProbingHashST<Integer, Aula> aulas) {
        this.aulas = aulas;
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

    public LinearProbingHashST<String, Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(LinearProbingHashST<String, Turma> turmas) {
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


            for (String key : professores.keys()) {
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
        if (professores == null){
            professores = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0];
            String email = texto[1];
            String data_nascimento = texto[2];
            String morada = texto[3];
            String horario_atendimento = texto[4];
            String code = texto[5];
            Integer gabinete = Integer.parseInt(texto[6]); //cast from string to integer

            Professor professor = new Professor(nome, email, new Date(), morada, new Date(), code, gabinete);
            professores.put(code, professor);
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

            for (String key : unidades_curriculares.keys()) {
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

    public void readFileUC() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/UC.txt");
        if (unidades_curriculares == null){
            unidades_curriculares = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0];
            Integer creditos = Integer.parseInt(texto[1]); //cast from string to integer

            Unidade_Curricular unidade_curricular = new Unidade_Curricular(nome, creditos);
            unidades_curriculares.put(nome, unidade_curricular);
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


            for (String key : turmas.keys()) {
                //Turma(String codigo)
                pw.println(turmas.get(key).getCodigo());
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

    public void readFileTurma() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/Turmas.txt");
        if (turmas == null){
            turmas = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String codigo = texto[0];

            Turma turma = new Turma(codigo);
            turmas.put(codigo, turma);
        }
    }

    public void dumpAula(){

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros", "Aulas.txt");
            fw = new FileWriter(f);
            System.out.println("FilePrintWriter - main(): encoding = " + fw.getEncoding());
            pw = new PrintWriter(fw);


            for (Integer key : aulas.keys()) {
                //Aula(Date hora_inicio, Date hora_fim, Turma t)
                pw.println(aulas.get(key).getHora_inicio() + ";" + aulas.get(key).getHora_fim() + ";" + aulas.get(key).getTurma());
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

    public void readFileAulas() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/Aulas.txt");
        Integer id = 0;

        if (aulas == null) {
            aulas = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String hora_inicio = texto[0];
            String hora_fim = texto[1];
            Turma t = null;
            Sala s = null;

            //SimpleDateFormat formatter = new SimpleDateFormat("hh-nn-e", Locale.ENGLISH);
            //Date date = formatter.parse(hora_inicio); 

            Aula aula = new Aula(new Date(), new Date(), s, t);
            aulas.put(id, aula);
            id++;
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

    public void readFileSala() {
        In in = new In("/Users/barbaramagalhaes/IdeaProjects/Projeto_LP2_AED2_v2/src/edu/ufp/inf/projeto/ficheiros/Salas.txt");
        if (salas == null){
            salas = new LinearProbingHashST<>();
        }

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            Integer numero = Integer.parseInt(texto[0]); //cast from string to integer
            Integer capacidade = Integer.parseInt(texto[1]); //cast from string to integer
            Integer numero_tomadas = Integer.parseInt(texto[2]); //cast from string to integer
            Integer piso = Integer.parseInt(texto[3]); //cast from string to integer


            Sala sala = new Sala(numero, capacidade, numero_tomadas, piso);
            salas.put(numero, sala);
        }
    }


    public void printLinearProbingPrintAlunos(){
        for (Integer key : this.getAlunos().keys()) {
            //Aluno(String nome, String email, Date data_nascimento, String morada, int numero)
            System.out.println(this.getAlunos().get(key).getNome() + ";" + this.getAlunos().get(key).getEmail() + ";" + this.getAlunos().get(key).getData_nascimento() + ";"
                    + this.getAlunos().get(key).getMorada() + ";" + this.getAlunos().get(key).getNumero());
        }
    }

    public void printLinearProbingPrintProfessor(){
        for (String key : this.getProfessores().keys()) {
            //Professor(String nome, String email, Date data_nascimento, String morada, Date horario_atendimento, String code, int gabinete)
            System.out.println(this.getProfessores().get(key).getNome() + ";" + this.getProfessores().get(key).getEmail() + ";" + this.getProfessores().get(key).getData_nascimento() + ";"
                    + this.getProfessores().get(key).getMorada() + ";" + this.getProfessores().get(key).getHorario_atendimento()
                    + ";" + this.getProfessores().get(key).getCode() + ";" + this.getProfessores().get(key).getGabinete());
        }
    }

    public void printLinearProbingPrintUC(){
        for (String key : this.getUnidades_curriculares().keys()) {
            //Unidade_Curricular(String nome, int creditos)
            System.out.println(this.getUnidades_curriculares().get(key).getNome() + ";" + this.getUnidades_curriculares().get(key).getCreditos());
        }
    }

    public void printLinearProbingPrintTurma(){
        for (String key : this.getTurmas().keys()) {
            //Turma(String codigo)
            System.out.println(this.getTurmas().get(key).getCodigo());
        }
    }

    public void printLinearProbingPrintAula(){
        for (Integer key : this.getAulas().keys()) {
            //Aula(Date hora_inicio, Date hora_fim)
            System.out.println(this.getAulas().get(key).getHora_inicio() + ";" + this.getAulas().get(key).getHora_fim() + ";" + this.getAulas().get(key).getTurma());
        }
    }

    public void printLinearProbingPrintSala(){
        for (Integer key : this.getSalas().keys()) {

            System.out.println(this.getSalas().get(key).getNumero() + ";" + this.getSalas().get(key).getCapacidade() + ";" + this.getSalas().get(key).getNumero_tomadas() + ";"
                    + this.getSalas().get(key).getPiso());
        }
    }
}