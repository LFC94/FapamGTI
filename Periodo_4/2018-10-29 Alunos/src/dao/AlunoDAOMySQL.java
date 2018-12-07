package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import classes.Alunos;
import conexao.MySql;
import interfaces.InterfaceAluno;

public class AlunoDAOMySQL implements InterfaceAluno {

	@Override
	public void cadastra(Alunos alunos) throws Exception {
		try (Connection conect = MySql.connectar()) {
			PreparedStatement statement;
			if(alunos.getId() <= 0) {
				String sql = "INSERT INTO aluno(nome, matricula,matriculado)values(?,?,?);";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, alunos.getNome());
				statement.setString(2, alunos.getMatricula());
				statement.setBoolean(3, alunos.isMatriculado());			
			}else {
				String sql = "UPDATE aluno SET nome = ? ,matricula = ? ,matriculado = ? WHERE id = ?;";
				statement = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, alunos.getNome());
				statement.setString(2, alunos.getMatricula());
				statement.setBoolean(3, alunos.isMatriculado());
				statement.setInt(4, alunos.getId());
			}
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
	        if (rs.next()){
	            alunos.setId(rs.getInt(1));
	        }			
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void remove(Alunos alunos) throws Exception {
		try (Connection conect = MySql.connectar()) {
			String sql = "DELETE FROM aluno WHERE nome = '" + alunos.getNome() + "'";
			PreparedStatement statement = conect.prepareStatement(sql);
			statement.execute();
			statement.close();
			conect.close();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public ArrayList<Alunos> busca(String nome) throws Exception {

		try (Connection conect = MySql.connectar()) {
			ArrayList<Alunos> alunos = new ArrayList<>();
			String sql = "SELECT * FROM aluno WHERE nome LIKE '" + nome + "%'";
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Alunos al = new Alunos();
				al.setId(resultSet.getInt("id"));
				al.setNome(resultSet.getString("nome"));
				al.setMatricula(resultSet.getString("matricula"));
				al.setMatriculado(resultSet.getBoolean("matriculado"));
				alunos.add(al);
			}
			statement.close();
			conect.close();
			return alunos;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	@Override
	public Alunos busca(int id) throws Exception {
		try (Connection conect = MySql.connectar()) {
			Alunos alunos = new Alunos();
			String sql = "SELECT * FROM aluno WHERE id = " + String.valueOf(id) ;
			PreparedStatement statement = conect.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {		
				alunos.setId(resultSet.getInt("id"));
				alunos.setNome(resultSet.getString("nome"));
				alunos.setMatricula(resultSet.getString("matricula"));
				alunos.setMatriculado(resultSet.getBoolean("matriculado"));				
			}
			statement.close();
			conect.close();
			return alunos;
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

}
