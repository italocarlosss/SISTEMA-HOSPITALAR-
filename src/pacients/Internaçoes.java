package pacients;


import java.time.LocalDateTime;

import Consultas.Salas;
import Entidades.pacientes.Medicos;
import Entidades.pacientes.Paciente;
import java.util.ArrayList
; 
public class Internaçoes {
    private Paciente internado;
    private Medicos medicos;
    private Situaçao situaçao;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private ArrayList<String> diagnostico;
    private Salas local;
    private double valorInterna;

public Internaçoes(Paciente internado, Medicos medicos, Situaçao situaçao, LocalDateTime entrada, LocalDateTime saida, ArrayList<String> diagnostico, Salas local, Double valorInterna){
    this.internado = internado;
    this.medicos = medicos;
    this.situaçao = situaçao;
    this.entrada = entrada;
    this.saida = saida;
    this.diagnostico = diagnostico;
    this.local = local;
    this.valorInterna= valorInterna;}

public void setInternado(Paciente internado)   {
     this.internado = internado;
}
public Paciente getInternado() {
    return internado;
}
public void setMedicos(Medicos medicos)   {
     this.medicos = medicos;
}
public Medicos getMedicos() {
    return medicos;
}
public void setSituaçao(Situaçao situaçao)   {
     this.situaçao = situaçao;
}
public LocalDateTime getEntrada() {
    return entrada;
}
public void setEntrada(LocalDateTime entrada)   {
     this.entrada = entrada;
}
public LocalDateTime getSaida() {
    return saida;
}
public void setSaida(LocalDateTime saida)   {
     this.saida = saida;
}
public Situaçao getSituaçao() {
    return situaçao;
}
public void setDiagnostico(ArrayList<String> diagnostico)   {
     this.diagnostico = diagnostico;
}
public ArrayList<String> getDiagnostico(){
    return diagnostico;
}
public void setLocal(Salas local)   {
     this.local = local;
}
public Salas getLocal(){
    return local;
}
public void setValorInterna(Double valorInterna)   {
     this.valorInterna = valorInterna;
}
public Double getValorInterna(){
    return valorInterna;
}

public boolean Atv() {
        return saida == null;
    }

public void dadosInternado(){
    System.out.println("Paciente internado: " + internado + "Entrou:" + entrada + "Saiu:" + saida == null +"\nMedico responsável: " + medicos + "\nSituação: " + situaçao + "\nMotivo da internação: " + diagnostico + "\nLocal: " + local + "\nValor da internação: " + valorInterna);
}}
