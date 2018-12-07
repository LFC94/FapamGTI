package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import classe.Bebidas;
import conexao.MySql;
import interfaces.InterfaceBebida;

public class DAOMySQLBebida implements InterfaceBebida {

	@Override
	public void cadastra(Bebidas bebidas) throws Exception {
		try (Connection conect = MySql.connectar()) {
			PreparedStatement statement;
			if (bebidas.getId() <= 0) {
				String sql = "INSERT INTO bebidas (nome, info, volume_emb) VALUE (?,?,?);";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, bebidas.getNome());
				statement.setString(2, bebidas.getInfo());
				statement.setDouble(3, bebidas.getVolume_emb());
			} else {
				String sql = "UPDATE bebidas SET nome = ? ,info = ? ,volume_emb = ? WHERE id = ?;";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, bebidas.getNome());
				statement.setString(2, bebidas.getInfo());
				statement.setDouble(3, bebidas.getVolume_emb());
				statement.setInt(4, bebidas.getId());
			}
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				bebidas.setId(rs.getInt(1));
			}
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public void remove(Bebidas bebidas) throws Exception {
		try (Connection conect = MySql.connectar()) {
			String sql = "DELETE FROM bebidas WHERE id = " + String.valueOf(bebidas.getId());
			PreparedStatement statement = conect.prepareStatement(sql);
			statement.execute();
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public ArrayList<Bebidas> busca(String nome) throws Exception {

		try (Connection conect = MySql.connectar()) {
			ArrayList<Bebidas> bebidas = new ArrayList<>();
			String sql = "SELECT * FROM bebidas WHERE nome LIKE '" + nome + "%' ORDER BY nome";
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Bebidas bebida = new Bebidas();
				bebida.setId(resultSet.getInt("id"));
				bebida.setNome(resultSet.getString("nome"));
				bebida.setInfo(resultSet.getString("info"));
				bebida.setVolume_emb(resultSet.getDouble("volume_emb"));
				bebidas.add(bebida);
			}
			statement.close();
			conect.close();
			return bebidas;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public Bebidas busca(int id) throws Exception {
		try (Connection conect = MySql.connectar()) {
			Bebidas bebidas = new Bebidas();
			String sql = "SELECT * FROM bebidas WHERE id = " + String.valueOf(id);
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bebidas.setId(resultSet.getInt("id"));
				bebidas.setNome(resultSet.getString("nome"));
				bebidas.setInfo(resultSet.getString("info"));
				bebidas.setVolume_emb(resultSet.getDouble("volume_emb"));
			}
			statement.close();
			conect.close();
			return bebidas;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

}
