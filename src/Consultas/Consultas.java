package Consultas;
import Entidades.pacientes.Paciente;
import java.time.LocalDateTime;

import Entidades.pacientes.Medicos;

public class Consultas {
    private Paciente paciente;
    private Medicos medico;
    private LocalDateTime data;
    private Salas local;
    private Medicamentos diagnostico;
    private Confirmaçao confirmaçao; 

public Consultas(Paciente paciente, Medicos medico, LocalDateTime data, Salas local, Medicamentos diagnostioco, Confirmaçao confirmaçao, double custoConsulta){
    this.paciente = paciente;
    this.medico = medico;
    this.data = data;
    this.local = local;
    this.diagnostico = diagnostioco;
    this.confirmaçao = confirmaçao;
}
public Paciente getPaciente() {
    return paciente;
}
public Medicos getMedico(){
    return medico;
}
public LocalDateTime getData(){
    return data;
}
public Salas getLocal(){
    return local;
}

public Medicamentos getDiagnostico(){
return diagnostico;

} 



public void Fimdeconsulta(Medicamentos diagnostico){
    this.diagnostico = diagnostico;
    this.confirmaçao = Confirmaçao.CONSULTA_AGENDADA;
}
    
public Confirmaçao getConfirmaçao(){
    return confirmaçao;
}
    @Override
    public String toString() {
        return "Consulta do Paciente:" + paciente.getNome() + ", Médico: " + medico.getNome() + ", data/hora: " + data + ", Local: " + local + "Diagnostico" + diagnostico + ", Status: " + confirmaçao;
}}

