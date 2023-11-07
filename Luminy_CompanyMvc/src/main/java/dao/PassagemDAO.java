package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConectionMySQL;
import modelos.Passagem;

public class PassagemDAO {

	// create
	public void create(Passagem Passagem) {

		String sql = "insert into Passagem (destino_passagem, preco_passagem) values (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Passagem.getDestino());
			pstm.setDouble(2, Passagem.getPreco());

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
	public List<Passagem> read() {
		List<Passagem> passagens = new ArrayList<Passagem>();
		String sql = "select * from Passagem;";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem passagem = new Passagem();

				passagem.setId(rset.getInt("id_passagem"));
				passagem.setDestino(rset.getString("destino_passagem"));
				passagem.setPreco(rset.getFloat("preco_passagem"));

				passagens.add(passagem);

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

		return passagens;
	}

	// update
	public void update(Passagem passagem) {

		String sql = "UPDATE Passagem SET destino_passagem = ?,  preco_passagem = ? WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getDestino());
			pstm.setFloat(2, passagem.getPreco());
			pstm.setInt(3, passagem.getId());

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
		String sql = "DELETE FROM Passagem WHERE id_passagem = ?";

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
	public Passagem readById(int id) {

		Passagem passagem = new Passagem();

		String sql = "SELECT * FROM Passagem WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId(rset.getInt("id_passagem"));
			passagem.setDestino(rset.getString("destino_passagem"));
			passagem.setPreco(rset.getFloat("preco_passagem"));

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

		return passagem;
	}
}