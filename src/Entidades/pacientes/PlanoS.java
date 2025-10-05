package Entidades.pacientes;

public enum PlanoS{

AMIL(0.50),
BRADESCO(0.60),
SUL_AMERICA(0.30),
HAPVIDA(0.25),
UNIMED(0.40),
PARTICULAR(0.0);

private double descontos;

PlanoS (double descontos) {
    this.descontos = descontos;
}
public double getDescontos() {
    return descontos;
}
}