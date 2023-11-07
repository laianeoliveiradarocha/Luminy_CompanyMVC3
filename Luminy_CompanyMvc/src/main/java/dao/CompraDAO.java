package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Clientes;
import modelos.Compras;
import modelos.Passagem;

public class CompraDAO {

	// create
	public void create(Compras compra) {

		String sql = "insert into compras (data_compras, id_clientes, id_passagem, total_compra) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_compra());
			pstm.setInt(2, compra.getCliente().getId());
			pstm.setInt(3, compra.getPassagem().getId());
			pstm.setDouble(4, compra.getTotal_compra());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// read
	public List<Compras> read() {
		List<Compras> compras = new ArrayList<Compras>();
		String sql = "select * from cliente_passagem order by id_compra;"; //tlavez de erro

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compras compra = new Compras();
				Passagem passagem = new Passagem();
				Clientes cliente = new Clientes();

				compra.setId(rset.getInt("id_compra"));
				compra.setData_compra(rset.getString("data_compras"));
				compra.setTotal_compra(rset.getDouble("total_compra"));

				passagem.setDestino(rset.getString("destino_passagem"));
				passagem.setId(rset.getInt("id_passagem"));
				passagem.setPreco(rset.getFloat("preco_passagem"));
				
				
				cliente.setEmail(rset.getString("email_cliente"));
				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome_cliente"));
				cliente.setSenha(rset.getString("senha_cliente"));

				compra.setPassagem(passagem);
				compra.setCliente(cliente);

				compras.add(compra);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	// update
	public void update(Compras compra) {

		String sql = "UPDATE Compras SET data_compras = ?, id_clientes = ?, id_passagem = ?,  total_compra = ? WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getData_compra());
			pstm.setInt(2, compra.getCliente().getId());
			pstm.setInt(3, compra.getPassagem().getId());
			pstm.setDouble(4, compra.getTotal_compra());
			pstm.setInt(5, compra.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Compras WHERE id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Compras readById(int id) {

		Compras compra = new Compras();

		String sql = "SELECT * FROM cliente_passagem WHERE id_Compra = ?"; // verificar

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			Passagem passagem = new Passagem();
			Clientes cliente = new Clientes();

			compra.setId(rset.getInt("id_compra"));
			compra.setData_compra(rset.getString("data_compras"));
			compra.setTotal_compra(rset.getDouble("total_compra"));

			passagem.setDestino(rset.getString("destino_passagem"));
			passagem.setId(rset.getInt("id_passagem"));
			passagem.setPreco(rset.getFloat("preco_passagem"));
			
			cliente.setEmail(rset.getString("email_cliente"));
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome_cliente"));
			cliente.setSenha(rset.getString("senha_cliente"));

			compra.setPassagem(passagem);
			compra.setCliente(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compra;
	}

}
