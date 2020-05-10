package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Vector;

public class Sala {

  private int numero;

  private int capacidade;

  private int numero_tomadas;

  private int piso;

  public Sala(int numero, int capacidade, int numero_tomadas, int piso) {
    this.numero = numero;
    this.capacidade = capacidade;
    this.numero_tomadas = numero_tomadas;
    this.piso = piso;
  }


  /**public boolean isAvailable(Turma a){
    for (Date di :horario.keys()) {
      Turma ai = horario.get(di);
      if(a.isInterseptedBy(ai)){
        return false;
      }
    }
    return true;
  }**/


  public void removerAula() {
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
}
