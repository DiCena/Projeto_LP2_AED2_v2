package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;

public class Turma {

  private String codigo;
  private Professor professor;
  private LinearProbingHashST<Integer,Aluno> alunos;
  private Unidade_Curricular uc;
  private Aula aula;


  public Turma(String codigo) {
        this.codigo = codigo;
  }

  /**
   * adiciona o aluno a st de alunos da turma se o mesmo ainda nao existir na turma, chama tambem a função para adicinar a turma ao aluno
   * @param a instancia do aluno a ser adicionado
   */
  public void adicionarAluno(Aluno a) {
    if (findAluno(a.getNumero())==null){
      alunos.put(a.getNumero(),a);
      a.adicionarTurma(this);
    }
  }

  /**
   * procura o aluno nesta turma e elimina o se existir, tambem chama a função para eliminar a turma do aluno em questao
   * @param n numero do aluno a eliminar
   * @return retorna o aluno eliminado ou null se o aluno nao existir
   */
  public Aluno removerAluno(int n) {
    Aluno a = findAluno(n);
    if(a!=null){
      alunos.delete(a.getNumero());
      a.removerTurma(this.codigo);
    }
    return a;
  }

  /**
   * procura nos alunos desta turma o aluno pelo numero
   * @param n numero do aluno
   * @return retorna a classe aluno com o aluno correspondente ou null se o aluno nao existir na turma
   */
  public Aluno findAluno(int n){
    return alunos.get(n);
  }

  /**
   * Procura nos alunos desta turma um aluno pelo nome
   * @param n nome do aluno
   * @return retorna a classe aluno com o aluno correspondente ou null se o aluno nao existir na turma
   */
  public Aluno findAluno(String n){
    for (Integer i:alunos.keys()) {
      if(alunos.get(i).getNome()==n){
        return alunos.get(i);
      }
    }
    return null;
  }


  /**
   * Muda o professor que leciona a cadeira
   * @param p novo professor a lecionar a cadeira
   */
  public void modifyProfessor(Professor p){
    this.professor.getTurmas().delete(this.getCodigo());
    this.professor = p;
    p.getTurmas().put(this.getCodigo(),this);
  }

  /**
   * modifica a aula para uma nova, apagando o registo da aula na sala anterior
   * @param a nova aula
   */
  public void modifyAula(Aula a){
    this.aula.getSala().removerAula(a);
    this.aula = a;
  }

  public void safeDelete(){
    this.professor.getTurmas().delete(this.getCodigo());
    for (Integer i:alunos.keys()) {
      alunos.get(i).removerTurma(this.codigo);
    }
    this.aula.getSala().removerAula(this.aula);
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

    public Unidade_Curricular getUc() {
        return uc;
    }

    public void setUc(Unidade_Curricular uc) {
        this.uc = uc;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
}





