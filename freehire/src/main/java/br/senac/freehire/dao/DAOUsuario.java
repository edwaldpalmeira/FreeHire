package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Usuario;

public class DAOUsuario {
	
	public static void inserir(Usuario usuario) throws Exception {
		
		String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, usuario.getLogin());
			in.setString(2, usuario.getSenha());
			
			in.execute();
		}
	}

	public static void excluir(int idUsuario) throws Exception {
		
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";
	
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
		
			in.setInt(1, idUsuario);
		
			in.execute();
		}
	}
	
	public static void atualizar(Usuario usuario) throws Exception {
		
		String sql = "UPDATE usuario SET login = ?, senha = ? WHERE idUsuario = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, usuario.getLogin());
			in.setString(2, usuario.getSenha());
			in.setInt(13, usuario.getIdUsuario());
			
			in.execute();
		}
	}
	
	public static List<Usuario> pesquisar(int idUsuario) throws Exception{
		
		String sql = "SELECT * FROM freelancer WHERE idUsuario like ?";
		
		List<Usuario> resultados = new ArrayList<Usuario>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, "%" + idUsuario + "%");
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Usuario usuario = new Usuario();
				
				
				usuario.setLogin(res.getString("login"));
				usuario.setSenha(res.getString("senha"));
				
				resultados.add(usuario);
			}
		}
		
		return resultados;
	}
	
	public static List<Usuario> listar() throws Exception {
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> resultados = new ArrayList<Usuario>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(res.getInt("idUsuario"));
				usuario.setLogin(res.getString("login"));
				usuario.setSenha(res.getString("senha"));
				
				resultados.add(usuario);
			}
		}
		
		return resultados;
	}

}
