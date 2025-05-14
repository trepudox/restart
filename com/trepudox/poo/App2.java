package com.trepudox.poo;

public class App2 {

    public static void main(String[] args) {
        Animal tarzan = new Cachorro("Tarzan", "preto", 4, Sexo.MACHO);
        Animal mel = new Cachorro("Mel", "caramelo", 4, Sexo.FEMEA);

        Animal sombra = new Gato("Sombra", "preto", 4, Sexo.MACHO);
        Animal kiara = new Gato("Kiara", "bege", 4, Sexo.FEMEA);

        tarzan.emitirSom();
        mel.emitirSom();

        sombra.emitirSom();
        kiara.emitirSom();
    }

}
