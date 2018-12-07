package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {
	public static Connection connectar() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/escola","root","");
	}
}
