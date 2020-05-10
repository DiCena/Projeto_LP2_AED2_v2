package edu.ufp.inf.projeto;

public class Aula {

  private Date hora_inicio;
  private Date hora_fim;
  private Sala sala;
  private Turma turma;

  public Aula(Date hora_inicio, Date hora_fim, Sala s, Turma t) {
    this.hora_inicio = hora_inicio;
    this.hora_fim = hora_fim;
    this.turma = t;
    this.sala = s;
  }

  public void modifyTime(Date i, Date f){
    this.hora_inicio = i;
    this.hora_fim = f;
  }

  public boolean isInterseptedBy(Aula a){
    return a.getHora_inicio().isBetween(this.hora_inicio, this.hora_fim) || a.getHora_fim().isBetween(this.hora_inicio, this.hora_fim);
  }

  public void modifySala(Sala s){
    this.sala = s;
  }

  public Date getHora_inicio() {
    return hora_inicio;
  }

  public void setHora_inicio(Date hora_inicio) {
    this.hora_inicio = hora_inicio;
  }

  public Date getHora_fim() {
    return hora_fim;
  }

  public void setHora_fim(Date hora_fim) {
    this.hora_fim = hora_fim;
  }

  public Sala getSala() {
    return sala;
  }

  public void setSala(Sala sala) {
    this.sala = sala;
  }

  public Turma getTurma() {
    return turma;
  }

  public void setTurma(Turma turma) {
    this.turma = turma;
  }
}