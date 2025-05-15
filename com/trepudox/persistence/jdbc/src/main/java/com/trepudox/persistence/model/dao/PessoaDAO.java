package com.trepudox.persistence.model.dao;

import com.trepudox.persistence.db.DBConnection;
import com.trepudox.persistence.model.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
* Horroroso pra manutenção, o ideal seria ter as querys prontas,
* fazer um loop usando varargs e Pattern Matching pra settar a
* ordem dos argumentos, dessa forma seria possível usar cerca de
* 3 métodos e atingir o mesmo resultado.
* */
public class PessoaDAO {

    private PessoaDAO() {}

    public static int create(String nome, LocalDate dataNascimento) {
        String query = "INSERT INTO pessoa(nome, data_nascimento) VALUE (?, ?);";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setString(2, dataNascimento.toString());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public static List<Pessoa> getAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        final String query = "SELECT * FROM pessoa;";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        pessoas.add(Pessoa.builder()
                                .id(rs.getInt("id"))
                                .nome(rs.getString("nome"))
                                .dataNascimento(rs.getDate("data_nascimento").toLocalDate())
                                .build());
                    }
                }

            } catch (SQLException e) {
                System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
                e.printStackTrace();
            }

        return pessoas;
    }

    public static Optional<Pessoa> getById(int id) {
        final String query = "SELECT * FROM pessoa WHERE id = ?;";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(Pessoa.builder()
                            .id(rs.getInt("id"))
                            .nome(rs.getString("nome"))
                            .dataNascimento(rs.getDate("data_nascimento").toLocalDate())
                            .build());
                }

            }

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public static int updateById(int id, String nome, LocalDate dataNascimento) {
        String query = "UPDATE pessoa SET nome = ? AND data_nascimento ? WHERE id = ?;";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setString(2, dataNascimento.toString());
            stmt.setInt(3, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public static int updateNomeById(int id, String nome) {
        String query = "UPDATE pessoa SET nome = ? WHERE id = ?;";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setInt(2, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public static int updateDataNascimentoById(int id, LocalDate dataNascimento) {
        String query = "UPDATE pessoa SET data_nascimento = ? WHERE id = ?;";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, dataNascimento.toString());
            stmt.setInt(2, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public static int deleteById(int id) {
        String query = "DELETE pessoa WHERE id = ?;";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.printf("%nDeu erro papai: %d - %s%n%n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }
}
