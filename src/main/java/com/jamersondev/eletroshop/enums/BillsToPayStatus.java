package com.jamersondev.eletroshop.enums;

public enum BillsToPayStatus {

    COBRANCA("Pagar"),
    ABERTA("Aberta"),
    VENCIDA("Vencida"),

    COLABORADOR("Salários dos Colaboradores"),
    ENERGIA("Energia elétrica"),
    AGUA("Água"),
    ALUGUEL("Aluguel"),
    RENEGOCIADA("Renegociada"),
    QUITADA("Quitada");

    private String name;

    BillsToPayStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
