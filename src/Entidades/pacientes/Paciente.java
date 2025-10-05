package Entidades.pacientes;
import java.util.ArrayList;

import pacients.InternaçaoMotivos;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<InternaçaoMotivos> internaçoes;
    private ArrayList<Historico> historicConsultas;
    private double saldo;

public Paciente(String nome, int idade, String cpf, ArrayList<InternaçaoMotivos> internaçoes, ArrayList<Historico> historicConsultas, double saldo){ 

this.nome = nome;
this.idade = idade;
this.cpf = cpf;
this.internaçoes = internaçoes;
this.historicConsultas = historicConsultas;
this.saldo = saldo;
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
public void setSaldo(double saldo)   {
     this.saldo = saldo;
}
public double getSaldo() {
     return saldo;
}

public void DinheiroConsulta(double valor) {
    if (saldo >= valor) {
        saldo -= valor;
        System.out.println("Consulta paga com sucesso. Saldo restante: " + saldo);
    } else {
        System.out.println("Saldo insuficiente para pagar a consulta.");
    }
}

public void dadosPacientes() {
    System.out.println("Paciente: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nSaldo: " + saldo + "\nHistórico de internações:" + internaçoes + "\nHistórico de consultas:" + historicConsultas);
}
}
