package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.Vector;

public class Unidade_Curricular {

  private String nome;

  private int creditos;

  private ArrayList<Turma> turmas;

  public Unidade_Curricular(String nome, int creditos) {
    this.nome = nome;
    this.creditos = creditos;
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

  public ArrayList<Turma> getTurmas() {
    return turmas;
  }

  public void setTurmas(ArrayList<Turma> turmas) {
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