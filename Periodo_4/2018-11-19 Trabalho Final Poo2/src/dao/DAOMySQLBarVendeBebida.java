package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import classe.Bar_Vende_Vebida;
import classe.Bares;
import classe.Bebidas;
import conexao.MySql;
import interfaces.InterfaceBar;
import interfaces.InterfaceBarVendeBebida;

public class DAOMySQLBarVendeBebida implements InterfaceBarVendeBebida {

	@Override
	public void cadastra(Bar_Vende_Vebida bvb) throws Exception {
		try (Connection conect = MySql.connectar()) {
			PreparedStatement statement;
			
			String sql = "CALL grava_bar_vende_bebida (?,?,?);";
			statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, bvb.getBares().getId());
			statement.setInt(2, bvb.getBebidas().getId());
			statement.setDouble(3, bvb.getValor());
		
			statement.execute();
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public void remove(Bar_Vende_Vebida bvb) throws Exception {
		try (Connection conect = MySql.connectar()) {
			String sql = "DELETE FROM bar WHERE barid = " + String.valueOf(bvb.getBares().getId())+" and bebidaid = " + String.valueOf(bvb.getBebidas().getId());
			PreparedStatement statement = conect.prepareStatement(sql);
			statement.execute();
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}

	}

	@Override
	public ArrayList<Bar_Vende_Vebida> busca(Bares bares) throws Exception {

		try (Connection conect = MySql.connectar()) {
			ArrayList<Bar_Vende_Vebida> bar_ven_beb = new ArrayList<>();
			String sql = "SELECT barid, bar.nome nomebar, bar.fantasia barfantasia, bar.capacidade barcapacidade, bebidaid, bebidas.nome nomebebida, bebidas.volume_emb volumbebida, bebidas.info infobebida, valor "+
				 	 " FROM bar_vende_bebida INNER JOIN bar on bar.id = bar_vende_bebida.barid INNER JOIN bebidas ON bebidas.id = bebidaid  WHERE barid = "+String.valueOf(bares.getId())
				 	 +" ORDER BY bebidas.nome";
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Bar_Vende_Vebida ven = new Bar_Vende_Vebida();
				ven.setBares(bares);
				Bebidas b = new Bebidas();
				b.setId(resultSet.getInt("bebidaid"));
				b.setNome(resultSet.getString("nomebebida"));
				b.setVolume_emb(resultSet.getDouble("volumbebida"));
				b.setInfo(resultSet.getString("infobebida"));
				ven.setBebidas(b);
				ven.setValor(resultSet.getDouble("valor"));
				bar_ven_beb.add(ven);
			}
			statement.close();
			conect.close();
			return bar_ven_beb;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public ArrayList<Bar_Vende_Vebida> busca(Bebidas bebidas) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bar_Vende_Vebida> busca() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
