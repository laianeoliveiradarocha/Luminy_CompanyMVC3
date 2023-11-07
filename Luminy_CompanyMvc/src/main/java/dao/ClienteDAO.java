package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Clientes;

public class ClienteDAO {

	//create
	public void create(Clientes cliente) {
		
		String sql = "insert into Clientes (nome_cliente, email_cliente, senha_cliente) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace ();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	
	//read
	public List<Clientes> read() {
		List<Clientes> clientes = new ArrayList<Clientes>();
		String sql = "select * from Clientes;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Clientes cliente = new 	Clientes();
				
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome_cliente"));
				cliente.setEmail(rset.getString("email_cliente"));
				cliente.setSenha(rset.getString("senha_cliente"));
				
				clientes.add(cliente);
				
			}
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		return clientes;
	}
	
	//update
	public void update(Clientes cliente) {
		
String sql = "UPDATE Clientes SET nome_cliente = ?, email_cliente = ?, senha_cliente = ? WHERE id_cliente = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			pstm.setInt(4,  cliente.getId());
			
			pstm.execute();
		
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	}
	
	//delete
	public void delete(int id) {
		String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		
	}
	
	//readById
	public Clientes readById(int id) {
		
		Clientes cliente = new Clientes();
		
	String sql = "SELECT * FROM Clientes WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
						
			conn = ConectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome_cliente"));
			cliente.setEmail(rset.getString("email_cliente"));
			cliente.setSenha(rset.getString("senha_cliente"));
			
					
	}catch (Exception e) {
		e.printStackTrace ();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		
		return cliente;
	}
}
