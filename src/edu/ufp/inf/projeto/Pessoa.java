package edu.ufp.inf.projeto;


public abstract class Pessoa {

  private String nome;

  private String email;

  private Date data_nascimento;

  private String morada;

  public Pessoa(String nome, String email, Date data_nascimento, String morada) {
    this.setNome(nome);
    this.setEmail(email);
    this.setData_nascimento(data_nascimento);
    this.setMorada(morada);
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getData_nascimento() {
    return data_nascimento;
  }

  public void setData_nascimento(Date data_nascimento) {
    this.data_nascimento = data_nascimento;
  }

  public String getMorada() {
    return morada;
  }

  public void setMorada(String morada) {
    this.morada = morada;
  }

  @Override
  public String toString() {
    return "\nPessoa{" +
            "\nnome='" + nome + '\'' +
            ", \nemail='" + email + '\'' +
            ", \ndata_nascimento=" + data_nascimento +
            ", \nmorada='" + morada + '\'' +
            '}';
  }
}