package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import classe.Bares;
import conexao.MySql;
import interfaces.InterfaceBar;

public class DAOMySQLBar implements InterfaceBar {

	@Override
	public void cadastra(Bares bares) throws Exception {
		try (Connection conect = MySql.connectar()) {
			PreparedStatement statement;
			if (bares.getId() <= 0) {
				String sql = "INSERT INTO bar (nome, fantasia, capacidade) VALUE (?,?,?);";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, bares.getNome());
				statement.setString(2, bares.getFantasias());
				statement.setInt(3, bares.getCapacidade());
			} else {
				String sql = "UPDATE bar SET nome = ? ,fantasia = ? ,capacidade = ? WHERE id = ?;";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, bares.getNome());
				statement.setString(2, bares.getFantasias());
				statement.setInt(3, bares.getCapacidade());
				statement.setInt(4, bares.getId());
			}
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				bares.setId(rs.getInt(1));
			}
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public void remove(Bares bares) throws Exception {
		try (Connection conect = MySql.connectar()) {
			String sql = "DELETE FROM bar WHERE id = " + String.valueOf(bares.getId());
			PreparedStatement statement = conect.prepareStatement(sql);
			statement.execute();
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public ArrayList<Bares> busca(String nome) throws Exception {

		try (Connection conect = MySql.connectar()) {
			ArrayList<Bares> bares = new ArrayList<>();
			String sql = "SELECT * FROM bar WHERE nome LIKE '" + nome + "%' ORDER BY nome";
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Bares bar = new Bares();
				bar.setId(resultSet.getInt("id"));
				bar.setNome(resultSet.getString("nome"));
				bar.setFantasias(resultSet.getString("fantasia"));
				bar.setCapacidade(resultSet.getInt("capacidade"));
				bares.add(bar);
			}
			statement.close();
			conect.close();
			return bares;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public Bares busca(int id) throws Exception {
		try (Connection conect = MySql.connectar()) {
			Bares bar = new Bares();
			String sql = "SELECT * FROM bar WHERE id = " + String.valueOf(id);
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bar.setId(resultSet.getInt("id"));
				bar.setNome(resultSet.getString("nome"));
				bar.setFantasias(resultSet.getString("fantasia"));
				bar.setCapacidade(resultSet.getInt("capacidade"));
			}
			statement.close();
			conect.close();
			return bar;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

}
