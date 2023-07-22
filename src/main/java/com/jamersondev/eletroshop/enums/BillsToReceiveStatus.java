package com.jamersondev.eletroshop.enums;

public enum BillsToReceiveStatus {

    COBRANCA("Pagar"),
    ABERTA("Aberta"),
    VENCIDA("Vencida"),
    QUITADA("Quitada");
   private String name;

    BillsToReceiveStatus(String name) {
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
