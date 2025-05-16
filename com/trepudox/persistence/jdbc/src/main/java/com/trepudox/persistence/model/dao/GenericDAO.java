package com.trepudox.persistence.model.dao;

import com.trepudox.persistence.db.DBConnection;
import com.trepudox.persistence.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAO<T, ID> {

    public abstract int create(T o);

    public abstract List<T> getAll();

    public abstract Optional<T> getById(ID id);

    public abstract int update(T o);

    public abstract int deleteById(ID id);

    protected int executeUpdate(String query, Object... args) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            fillPreparedStatementArguments(stmt, args);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            treatSQLException(e);
        }

        return 0;
    }

    protected Optional<Pessoa> executeSpecificQuery(String query, Object... args) {
        Optional<Pessoa> pessoaOptional = Optional.empty();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            fillPreparedStatementArguments(stmt, args);

            try (ResultSet rs = stmt.executeQuery()) {
                int aux = 0;

                while (rs.next()) {
                    if (aux > 0) {
                        throw new IllegalArgumentException(String.format("Mais de um registro encontrado para " +
                                "os argumentos enviados: %s", Arrays.deepToString(args)));
                    }

                    pessoaOptional = Optional.of(Pessoa.builder()
                            .id(rs.getInt("id"))
                            .nome(rs.getString("nome"))
                            .dataNascimento(rs.getDate("data_nascimento").toLocalDate())
                            .build());

                    aux++;
                }
            }

        } catch (SQLException e) {
            treatSQLException(e);
        }

        return pessoaOptional;
    }

    protected List<Pessoa> executeGenericQuery(String query, Object... args) {
        List<Pessoa> pessoaList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            fillPreparedStatementArguments(stmt, args);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    pessoaList.add(Pessoa.builder()
                            .id(rs.getInt("id"))
                            .nome(rs.getString("nome"))
                            .dataNascimento(rs.getDate("data_nascimento").toLocalDate())
                            .build());
                }
            }

        } catch (SQLException e) {
            treatSQLException(e);
        }

        return pessoaList;
    }

    protected void fillPreparedStatementArguments(PreparedStatement stmt, Object... args) throws SQLException {
        for (int i = 1; i <= args.length; i++) {
            Object o = args[i - 1];

            switch (o) {
                case String string -> stmt.setString(i, string);
                case LocalDate localDate -> stmt.setString(i, localDate.toString());
                case Integer integer -> stmt.setInt(i, integer);
                default -> throw new IllegalArgumentException(String.format("Tipo não esperado pelo sistema: %s", o.getClass()));
            }
        }
    }

    protected  void treatSQLException(SQLException e) {
        System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
        e.printStackTrace();
    }

}
