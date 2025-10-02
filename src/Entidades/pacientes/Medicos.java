package Entidades.pacientes;

public class Medicos{
    private String nome;
    private String CRM;
    private String especialidades;
    private double custo;
    

public Medicos(String nome, String CRM, String especialidades, double custo){
    this.nome = nome;
    this.CRM = CRM;
    this.especialidades = especialidades;
    this.custo = custo; }

public void setNome(String nome) {
    this.nome = nome;
}
public String getNome() {
    return nome;
}

public void setCRM(String CRM) {
    this.CRM = CRM;
}
public String getCRM() {
    return CRM;
}
public void setEspecialidades(String especialidades)   {
     this.especialidades = especialidades;
}
public String getEspecialidades() {
     return especialidades;
} 
public double custo (PlanoS plano) {
    double descontos = plano.getDescontos();
    return custo * (1 - descontos);}
 
public void dadosMedico(){
    System.out.println("\nMédico: " + nome + "\nCRM: " + CRM +"\nEspecialidade: " + especialidades + "\nCusto da Consulta sem plano(PARTICULAR):" + custo);{


    }

}}

//(public enum Especialidade
    //CLINICO_GERAL,
    //PEDIATRA, 
    //PSIQUIATRA, 
    //CARDIOLOGISTA, 
    //CIRURGIAO)