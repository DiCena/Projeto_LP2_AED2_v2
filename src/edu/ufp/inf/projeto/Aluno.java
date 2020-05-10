package edu.ufp.inf.projeto;


import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Calendar;

public class Aluno extends Pessoa {

  private int numero;

  private RedBlackBST<Date,Aula> horario;

  private LinearProbingHashST<String, Turma> turmas;

  public Aluno(String nome, String email, Date data_nascimento, String morada, int numero) {
    super(nome, email, data_nascimento, morada);
    this.numero = numero;
  }


  public void adicionarTurma(Turma t) {
    if (findTurma(t.getCodigo())!=null) {
      System.out.println("Aluno ja inscrito na turma!!");
    }
    else{
      getTurmas().put(t.getCodigo(),t);
      horario.put(t.getAula().getHora_inicio(),t.getAula());
    }
  }

  public Turma removerTurma(String n) {
    Turma t = findTurma(n);
    if (t==null){
      System.out.println("Aluno nao inscrito na turma!");
      return null;
    }
    else{
      turmas.delete(n);
      horario.delete(t.getAula().getHora_inicio());
      return t;
    }
  }

  public Turma findTurma(String nome){
    return getTurmas().get(nome);
  }

  public ArrayList<Aula> findAulasDia(int d, Date lo, Date hi){
    ArrayList<Aula> aux = new ArrayList();
    for (Date di:horario.keys(lo, hi)) {
      if (di.getDias_semana()==d){
        aux.add(horario.get(di));
      }
    }
    return aux;
  }

  public Aula nextAula(){
    Aula aux;
    java.util.Date agora =  new java.util.Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(agora);
    Date date = new Date(calendar.get(Calendar.DAY_OF_WEEK), agora.getHours(), agora.getMinutes());
    ArrayList<Aula> aulas = findAulasDia(calendar.get(Calendar.DAY_OF_WEEK), date, new Date(calendar.get(Calendar.DAY_OF_WEEK), 23, 59));
    aux = aulas.get(0);
    for (Aula ai:aulas) {
      if(ai.getHora_inicio().isBefore(aux.getHora_inicio())){
        aux = ai;
      }
    }
    return aux;
  }

  /**
   *
   * Get & Set
   *
   * */

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public LinearProbingHashST<String, Turma> getTurmas() {
    return turmas;
  }

  public void setTurmas(LinearProbingHashST<String, Turma> turmas) {
    this.turmas = turmas;
  }

  public RedBlackBST<Date, Aula> getHorario() {
    return horario;
  }

  public void setHorario(RedBlackBST<Date, Aula> horario) {
    this.horario = horario;
  }

  @Override
  public String toString() {
    return "\nAluno{" +
            "\nnumero=" + numero +
            ", \nhorario=" + horario +
            ", \nturmas=" + turmas +
            '}';
  }
}