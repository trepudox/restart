package com.trepudox.persistence;

import com.trepudox.persistence.model.Pessoa;
import com.trepudox.persistence.model.dao.PessoaDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        // CREATE
        int affectedRows = pessoaDAO.create(Pessoa.builder().nome("dummy").dataNascimento(LocalDate.now()).build());
        System.out.printf("Create: %b%n", affectedRows == 1);

        // READ
        List<Pessoa> pessoas = pessoaDAO.getAll();
        System.out.printf("GetAll: %s%n", pessoas);

        Optional<Pessoa> pessoaOptionalId1 = pessoaDAO.getById(1);
        Optional<Pessoa> pessoaOptionalId999 = pessoaDAO.getById(999);
        printGetPessoaById(pessoaOptionalId1);
        printGetPessoaById(pessoaOptionalId999);

        // UPDATE
        affectedRows = pessoaDAO.update(Pessoa.builder().id(4).nome("dummyyy").dataNascimento(LocalDate.now()).build());
        System.out.printf("Update: %b%n", affectedRows == 1);

        // DELETE
//        affectedRows = pessoaDAO.deleteById(3);
//        System.out.printf("Delete: %b%n", affectedRows == 1);
    }

    private static void printGetPessoaById(Optional<Pessoa> opt) {
        opt.ifPresentOrElse(System.out::println,
                () -> System.out.println("num tem :o"));
    }

}
