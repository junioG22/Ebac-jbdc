package Tabela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void inserirUsuario(String nome, String email) {

        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (

                Connection connection = ConnectionFactory.conectar();

                PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ) {

            preparedStatement.setString(1, nome);

            preparedStatement.setString(2, email);

            preparedStatement.executeUpdate();

            System.out.println("Usuário inserido com sucesso.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void deletarUsuario(String nome) {

        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (

                Connection connection = ConnectionFactory.conectar();

                PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ) {

            preparedStatement.setString(1, nome);

            int linhasAfetadas = preparedStatement.executeUpdate();

            System.out.println(linhasAfetadas + " usuário deletado.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void atualizarEmail(String nome, String novoEmail) {

        String sql = "UPDATE usuarios SET email = ? WHERE nome = ?";

        try (

                Connection connection = ConnectionFactory.conectar();

                PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ) {

            preparedStatement.setString(1, novoEmail);

            preparedStatement.setString(2, nome);

            int linhasAfetadas = preparedStatement.executeUpdate();

            System.out.println(linhasAfetadas + " usuário atualizado.");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void listarUsuarios() {

        String sql = "SELECT * FROM usuarios";

        try (

                Connection connection = ConnectionFactory.conectar();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String nome = resultSet.getString("nome");

                String email = resultSet.getString("email");

                System.out.println(
                        "ID: " + id +
                                " - Nome: " + nome +
                                " - Email: " + email
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
