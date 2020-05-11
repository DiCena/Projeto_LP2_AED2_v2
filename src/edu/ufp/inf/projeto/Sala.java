package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.RedBlackBST;


public class Sala {

  private int numero;

  private int capacidade;

  private int numero_tomadas;

  private int piso;

  private RedBlackBST<Date,Aula> horario;

  public Sala(int numero, int capacidade, int numero_tomadas, int piso) {
    this.numero = numero;
    this.capacidade = capacidade;
    this.numero_tomadas = numero_tomadas;
    this.piso = piso;
  }

  public void addAula(Aula a){
    if(this.isAvailable(a)){
      horario.put(a.getHora_inicio(), a);
    }
  }

  public void removerAula(Aula a) {
    if(horario.get(a.getHora_inicio())==a){
      horario.delete(a.getHora_inicio());
    }
  }

  public boolean isAvailable(Aula a){
    for (Date di :horario.keys()) {
      Aula ai = horario.get(di);
      if(a.isInterseptedBy(ai)){
        return false;
      }
    }
    return true;
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


  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public int getNumero_tomadas() {
    return numero_tomadas;
  }

  public void setNumero_tomadas(int numero_tomadas) {
    this.numero_tomadas = numero_tomadas;
  }

  public int getPiso() {
    return piso;
  }

  public void setPiso(int piso) {
    this.piso = piso;
  }

  @Override
  public String toString() {
    return "\nSala{" +
            "\nnumero=" + numero +
            ", \ncapacidade=" + capacidade +
            ", \nnumero_tomadas=" + numero_tomadas +
            ", \npiso=" + piso +
            '}';
  }

  public void setHorario(RedBlackBST<Date, Aula> horario) {
    this.horario = horario;
  }

  public RedBlackBST<Date, Aula> getHorario() {
    return horario;
  }
}
