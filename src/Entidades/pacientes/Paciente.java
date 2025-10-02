package Entidades.pacientes;
import java.util.ArrayList;

import pacients.InternaçaoMotivos;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<InternaçaoMotivos> internaçoes;
    private ArrayList<Historico> historicConsultas;

public Paciente(String nome, int idade, String cpf, ArrayList<InternaçaoMotivos> internaçoes, ArrayList<Historico> historicConsultas) {

this.nome = nome;
this.idade = idade;
this.cpf = cpf;
this.internaçoes = internaçoes;
this.historicConsultas = historicConsultas;
}

public void setNome(String nome)   {
     this.nome = nome;
}
public String getNome() {
     return nome;
}
public void setIdade(int idade)   {
     this.idade = idade;
}
public int getIdade() {
     return idade;
}
public void setCpf(String cpf) {
     this.cpf = cpf;
}
public String getCpf() {
     return cpf;
}     
public void setInternaçoes(ArrayList<InternaçaoMotivos> internaçoes)   {
     this.internaçoes = internaçoes;
}
public ArrayList<InternaçaoMotivos> getInternaçoes() { 
    return internaçoes;
}

public void sethistoricConsultas(ArrayList<Historico> historicConsultas)   {
     this.historicConsultas = historicConsultas;
}
public ArrayList<Historico> gethistoricConsultas() {
     return historicConsultas;
}
    

public void dadosPacientes() {
    System.out.println("Paciente: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nHistórico de internações:" + internaçoes + "\nHistórico de consultas:" + historicConsultas);
}     
}