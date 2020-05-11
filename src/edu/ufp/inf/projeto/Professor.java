package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Calendar;

public class Professor extends Pessoa {

  private Date horario_atendimento;

  private String code;

  private int gabinete;

  private RedBlackBST<Date,Aula> horario;

  private LinearProbingHashST<String, Turma> turmas;

  public Professor(String nome, String email, Date data_nascimento, String morada, Date horario_atendimento, String code, int gabinete) {
    super(nome, email, data_nascimento, morada);
    this.horario_atendimento=horario_atendimento;
    this.code = code;
    this.gabinete=gabinete;
  }

  public void adicionarTurma(Turma t) {
    if (findTurma(t.getCodigo())!=null) {
      System.out.println("Professor ja leciona essa turma!!");
    }
    else{
      turmas.put(t.getCodigo(),t);
      horario.put(t.getAula().getHora_inicio(),t.getAula());
    }
  }

  public Turma removerTurma(String n) {
    Turma t = findTurma(n);
    if (t==null){
      System.out.println("Professor nao leciona na turma!");
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
    for (Aula aula:aulas) {
      if(aula.getHora_inicio().isBefore(aux.getHora_inicio())){
        aux = aula;
      }
    }
    return aux;
  }

  public boolean inClass(){
    Date now = new Date();
    for (Date di:horario.keys()) {
      if(now.isBetween(horario.get(di).getHora_inicio(),horario.get(di).getHora_fim())){
        return true;
      }
    }
    return false;
  }


  public void editarAtendimento(Date h) {
    setHorario_atendimento(h);
  }

  public void editarGabinete(int g){
    setGabinete(g);
  }

  public Date getHorario_atendimento() {
    return horario_atendimento;
  }

  public void setHorario_atendimento(Date horario_atendimento) {
    this.horario_atendimento = horario_atendimento;
  }

  public int getGabinete() {
    return gabinete;
  }

  public void setGabinete(int gabinete) {
    this.gabinete = gabinete;
  }

  public RedBlackBST<Date, Aula> getHorario() {
    return horario;
  }

  public void setHorario(RedBlackBST<Date, Aula> horario) {
    this.horario = horario;
  }

  public LinearProbingHashST<String, Turma> getTurmas() {
    return turmas;
  }

  public void setTurmas(LinearProbingHashST<String, Turma> turmas) {
    this.turmas = turmas;
  }

  @Override
  public String toString() {
    return "\nProfessor{" +
            "\nhorario_atendimento=" + horario_atendimento +
            ", \ngabinete=" + gabinete +
            ", \nhorario=" + horario +
            ", \nturmas=" + turmas +
            '}';
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}