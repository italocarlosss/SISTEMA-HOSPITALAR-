package Entidades.pacientes;

public enum PlanoS{

AMIL(0.50),
BRADESCO(0.60),
SUL_AMERICA(0.30),
HAPVIDA(0.25);

private double descontos;

PlanoS (double descontos) {
    this.descontos = descontos;
}
public double getDescontos() {
    return descontos;
}
}