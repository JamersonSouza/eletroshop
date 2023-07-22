package com.jamersondev.eletroshop.enums;

import lombok.Getter;
import lombok.Setter;

public enum BillsToReceive {

    COBRANCA("Pagar"),
    ABERTA("Aberta"),
    VENCIDA("Vencida"),
    QUITADA("Quitada");
   private String name;

    BillsToReceive(String name) {
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
