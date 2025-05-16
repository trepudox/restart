package com.trepudox.persistence.model.dao;

import com.trepudox.persistence.model.Pessoa;

import java.util.List;
import java.util.Optional;

public class PessoaDAO extends GenericDAO<Pessoa, Integer> {

    @Override
    public int create(Pessoa p) {
        final String query = "INSERT INTO pessoa(nome, data_nascimento) VALUE (?, ?);";
        return executeUpdate(query, p.getNome(), p.getDataNascimento());
    }

    @Override
    public List<Pessoa> getAll() {
        final String query = "SELECT * FROM pessoa;";
        return executeGenericQuery(query);
    }

    @Override
    public Optional<Pessoa> getById(Integer id) {
        final String query = "SELECT * FROM pessoa WHERE id = ?;";
        return executeSpecificQuery(query, id);
    }

    @Override
    public int update(Pessoa p) {
        final String query = "UPDATE pessoa SET nome = ?, data_nascimento = ? WHERE id = ?;";
        return executeUpdate(query, p.getNome(), p.getDataNascimento(), p.getId());
    }

    @Override
    public int deleteById(Integer id) {
        final String query = "DELETE FROM pessoa WHERE id = ?;";
        return executeUpdate(query, id);
    }

}
