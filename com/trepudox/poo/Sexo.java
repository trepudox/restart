package com.trepudox.poo;

public enum Sexo {

    MACHO("Macho"), FEMEA("Femea");

    Sexo(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
