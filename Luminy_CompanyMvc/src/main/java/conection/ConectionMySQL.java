package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionMySQL {
	private static String URL = "jdbc:mysql://localhost:3306/luminy_company";
	private static String CLIENTE = "root";
	private static String SENHA = "Biomedicina1,";
	
	public static Connection createConnectionMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(URL, CLIENTE, SENHA);
		
				return connection;
	}
	
public static void main(String[] args)throws Exception{
	Connection con = createConnectionMySQL();
	
	if (con != null) {
		System.out.println(con + "\n\n **** Conexão obtida com sucesso! ****");
		con.close();
		
	}
	
	
}
}
