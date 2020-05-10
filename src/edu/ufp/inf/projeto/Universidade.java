package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;


public abstract class Universidade {

  private LinearProbingHashST<Integer, Aluno> alunos;

  private LinearProbingHashST<String,Professor> professores;

  private LinearProbingHashST<String, Unidade_Curricular> unidades_curriculares;

  private LinearProbingHashST<Integer, Sala> salas;

  private LinearProbingHashST<String, Turma> turmas;

  public void remove(Aluno a){
    if(exists(a)){
      alunos.delete(a.getNumero());
    }
  }
  public void remove(Professor p){
    if(exists(p)){
      professores.delete(p.getCode());
    }
  }
  public void remove(Unidade_Curricular uc){
    if(exists(uc)){
      unidades_curriculares.delete(uc.getNome());
    }
  }
  public void remove(Sala s){
    if(exists(s)){
      salas.delete(s.getNumero());
    }
  }
  public void remove(Turma t){
    if(exists(t)){
      turmas.delete(t.getCodigo());
    }
  }

  public void add(Aluno a){
    if(!exists(a)){
      alunos.put(a.getNumero(),a);
    }
  }

  public void add(Professor p){
    if(!exists(p)){
      professores.put(p.getCode(),p);
    }
  }

  public void add(Unidade_Curricular uc){
    if(!exists(uc)){
      unidades_curriculares.put(uc.getNome(),uc);
    }
  }

  public void add(Sala s){
    if(!exists(s)){
      salas.put(s.getNumero(),s);
    }
  }

  public void add(Turma t){
    if(!exists(t)){
      turmas.put(t.getCodigo(),t);
    }
  }

  public boolean exists(Aluno a){
    return alunos.get(a.getNumero()) == a;
  }

  public boolean exists(Professor p){
    return professores.get(p.getCode()) == p;
  }

  public boolean exists(Unidade_Curricular uc){
    return unidades_curriculares.get(uc.getNome()) == uc;
  }

  public boolean exists(Sala s){
    return salas.get(s.getNumero()) == s;
  }

  public boolean exists(Turma t){
    return turmas.get(t.getCodigo()) == t;
  }


  /**
   *
   *
   * Get & Sets
   *
   * */

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
}