package org.system.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
