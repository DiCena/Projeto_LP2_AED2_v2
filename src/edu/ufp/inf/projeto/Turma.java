package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;

public class Turma {

  private String codigo;
  private Professor professor;
  private LinearProbingHashST<Integer,Aluno> alunos;
  private String uc;
  private Aula aula;


  public Turma(String codigo, Professor professor, String uc, Aula aula) {
        this.codigo = codigo;
        this.professor = professor;
        this.uc = uc;
        this.aula = aula;
  }

  public void adicionarAluno(Aluno a) {
    if (findAluno(a.getNumero())==null){
      alunos.put(a.getNumero(),a);
    }
  }

  public Aluno removerAluno(String n) {
    Aluno a = findAluno(n);
    if(a!=null){
      alunos.delete(a.getNumero());
    }
    return a;
  }

  public Aluno findAluno(int n){
    return alunos.get(n);
  }

  public Aluno findAluno(String n){
    for (Integer i:alunos.keys()) {
      if(alunos.get(i).getNome()==n){
        return alunos.get(i);
      }
    }
    return null;
  }

  /**
   *
   * Get & Set
   *
   * */

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public LinearProbingHashST<Integer,Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(LinearProbingHashST<Integer,Aluno> alunos) {
    this.alunos = alunos;
  }


    @Override
    public String toString() {
        return "\nTurma{" +
                "\ncodigo='" + codigo + '\'' +
                ", \nprofessor=" + professor +
                ", \nalunos=" + alunos +
                '}';
    }

  public String getUc() {
    return uc;
  }

  public void setUc(String uc) {
    this.uc = uc;
  }

  public Aula getAula() {
    return aula;
  }

  public void setAula(Aula aula) {
    this.aula = aula;
  }
}





