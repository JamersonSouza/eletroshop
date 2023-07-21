package com.jamersondev.eletroshop.enums;

public enum TypeAddress {

    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private String name;

    TypeAddress(String name) {
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
