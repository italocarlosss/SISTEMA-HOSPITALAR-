package Entidades.pacientes;
import java.util.ArrayList;

import pacients.InternaçaoMotivos;

public class PacienteEspecial extends Paciente {
    private PlanoS planodesaude;

public PacienteEspecial( String nome, int idade, String cpf, ArrayList<InternaçaoMotivos> internaçoes, ArrayList<Historico> historicConsultas, PlanoS planodesaude){

    super(nome, idade, cpf, internaçoes, historicConsultas);
    this.planodesaude = planodesaude;
}
    public PlanoS getPlanodesaude() {
        return planodesaude;
    }

public void dadosPacientesEspeciais() {
  System.out.println("Nome:" + getNome() + "| Idade:" + getIdade() + "| CPF:" + getCpf() + "| Historico de internaçoes:" + getInternaçoes() + "Historico de consultas:" + gethistoricConsultas() + "| Plano de Saúde:" + planodesaude);
}
}