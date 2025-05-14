package com.trepudox.poo;

public class Gato extends Animal {

    public Gato(String nome, String cor, int patas, Sexo sexo) {
        this.setNome(nome);
        this.setCor(cor);
        this.setPatas(patas);
        this.setSexo(sexo);
    }

    @Override
    public void emitirSom() {
        System.out.println(this.getNome() + ": miau");
    }

}
