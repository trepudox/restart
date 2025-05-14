package com.trepudox.poo;

public class Cachorro extends Animal {

    public Cachorro(String nome, String cor, int patas, Sexo sexo) {
        this.setNome(nome);
        this.setCor(cor);
        this.setPatas(patas);
        this.setSexo(sexo);
    }

    @Override
    public void emitirSom() {
        System.out.println(this.getNome() + ": au au");
    }
}
