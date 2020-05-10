package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;

import java.util.ArrayList;
import java.util.Vector;

public class Unidade_Curricular {

  private String nome;

  private int creditos;

  private LinearProbingHashST<String, Turma> turmas;

  public Unidade_Curricular(String nome, int creditos) {
    this.nome = nome;
    this.creditos = creditos;
  }

  public void addTurma(Turma t, Universidade u){
    if(u.exists(t)){
      turmas.put(t.getCodigo(), t);
    }
  }

  public void removeTurma(Turma t){
    if (findTurma(t.getCodigo())!=null){
      t.safeDelete();
    }
  }

  public Turma findTurma(String t){
    return turmas.get(t);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCreditos() {
    return creditos;
  }

  public void setCreditos(int creditos) {
    this.creditos = creditos;
  }

  public LinearProbingHashST<String, Turma> getTurmas() {
    return turmas;
  }

  public void setTurmas(LinearProbingHashST<String, Turma> turmas) {
    this.turmas = turmas;
  }

  @Override
  public String toString() {
    return "\nUnidade_Curricular{" +
            "\nnome='" + nome + '\'' +
            ", \ncreditos=" + creditos +
            ", \nturmas=" + turmas +
            '}';
  }
}