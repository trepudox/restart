package com.trepudox.poo;

public abstract class Animal {

    private String nome;
    private String cor;
    private int patas;
    private Sexo sexo;

    private boolean dormindo = false;
    private boolean andando = false;

    public void dormir() {
        if (this.dormindo) {
            System.out.println(this.nome + " já está dormindo.");
        } else {
            this.andando = false;
            this.dormindo = true;
            System.out.println(this.nome + " agora está dormindo.");
        }
    }

    public void acordar() {
        if (this.dormindo) {
            this.dormindo = false;
            System.out.println(this.nome + " está acordado agora.");
        } else {
            System.out.println(this.nome + " já está acordado.");
        }
    }

    public void andar() {
        if (this.dormindo) {
            this.dormindo = false;
            System.out.println(this.nome + " está andando agora.");
        } else {
            System.out.println(this.nome + " já está andando.");
        }
    }

    public void pararDeAndar() {
        if (this.andando) {
            this.andando = false;
            System.out.println(this.nome + " parou de andar.");
        } else {
            System.out.println(this.nome + " já não estava andando.");
        }
    }

    public abstract void emitirSom();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPatas() {
        return this.patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
