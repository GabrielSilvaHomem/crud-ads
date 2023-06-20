package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroStorage {

	public static void inserir(Cadastro cadastro) {
		final String query = "INSERT INTO usuario (nome, idade,email,endereco,cep,telefone,usuario,senha,curso,observacao,ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, cadastro.getNome());
			prepStmt.setInt(2, cadastro.getIdade());
			prepStmt.setString(3, cadastro.getEmail());
			prepStmt.setString(4, cadastro.getEndereco());
			prepStmt.setString(5, cadastro.getCep());
			prepStmt.setString(6, cadastro.getTelefone());
			prepStmt.setString(7, cadastro.getUsuario());
			prepStmt.setString(8, cadastro.getSenha());
			prepStmt.setString(9, cadastro.getCurso());
			prepStmt.setString(10, cadastro.getObservacao());
			prepStmt.setString(11, cadastro.getAtivo());
			prepStmt.execute();

			rs = prepStmt.getGeneratedKeys();
			if (rs.next()) {
				cadastro.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void atualizar(Cadastro cadastro) {
		final String query = "UPDATE usuario SET nome = ?, idade = ?,email = ?,endereco = ?,cep = ?,telefone = ?,usuario = ?,senha = ?,curso = ?,observacao = ?,ativo = ? WHERE idUsuario = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, cadastro.getNome());
			prepStmt.setInt(2, cadastro.getIdade());
			prepStmt.setString(3, cadastro.getEmail());
			prepStmt.setString(4, cadastro.getEndereco());
			prepStmt.setString(5, cadastro.getCep());
			prepStmt.setString(6, cadastro.getTelefone());
			prepStmt.setString(7, cadastro.getUsuario());
			prepStmt.setString(8, cadastro.getSenha());
			prepStmt.setString(9, cadastro.getCurso());
			prepStmt.setString(10, cadastro.getObservacao());
			prepStmt.setString(11, cadastro.getAtivo());
			prepStmt.setInt(12, cadastro.getId());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 

	public static void remover(Cadastro cadastro) {
		final String query = "DELETE FROM usuario WHERE idUsuario = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, cadastro.getId());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 

	public static List<Cadastro> listar() {
		List<Cadastro> cadastros = new ArrayList<>();

		final String query = "SELECT * FROM usuario ORDER BY idUsuario ASC";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Cadastro cadastro = new Cadastro();
				cadastro.setId(rs.getInt("idUsuario"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setIdade(rs.getInt("idade"));
				cadastro.setEmail(rs.getString("email"));
				cadastro.setEndereco(rs.getString("endereco"));
				cadastro.setCep(rs.getString("cep"));
				cadastro.setTelefone(rs.getString("telefone"));
				cadastro.setUsuario(rs.getString("usuario"));
				cadastro.setSenha(rs.getString("senha"));
				cadastro.setCurso(rs.getString("curso"));
				cadastro.setObservacao(rs.getString("observacao"));
				cadastro.setAtivo(rs.getString("ativo"));

				cadastros.add(cadastro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cadastros;
	}

}
