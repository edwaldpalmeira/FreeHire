package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Projeto;

public class DAOProjeto {
	
	/**tirar duvida sobre a forma de inserir a chave estrangeira**/
	
	public static void inserir(Projeto projeto) throws Exception {
		
		String sql = "INSERT INTO projeto (nomeProjeto, descricaoProjeto, valorProjeto, valorAvaliacao, avaliacao, observacaoAvaliacao)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, projeto.getNomeProjeto());
			in.setString(2, projeto.getDescricaoProjeto());
			in.setDouble(3, projeto.getValorProjeto());
			in.setDouble(4, projeto.getValorAvaliacao());
			in.setInt(5, projeto.getAvaliacao());
			in.setString(6, projeto.getObservacaoAvaliacao());
			
			in.execute();
		}
	}
	
	public static void excluir(int idProjeto) throws Exception {
		String sql = "DELETE FROM projeto WHERE idProjeto = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setInt(1, idProjeto);
			
			in.execute();
		}
	}
	
	
	public static void atualizar(Projeto projeto) throws Exception {
		
		String sql = "UPDATE projeto SET nomeProjeto = ?, descricaoProjeto = ?, valorProjeto = ?, "
				+ "valorAvaliacao = ?, avaliacao = ?, observacaoAvaliacao = ? WHERE idProjeto = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, projeto.getNomeProjeto());
			in.setString(2, projeto.getDescricaoProjeto());
			in.setDouble(3, projeto.getValorProjeto());
			in.setDouble(4, projeto.getValorAvaliacao());
			in.setInt(5, projeto.getAvaliacao());
			in.setString(6, projeto.getObservacaoAvaliacao());
			in.setInt(7, projeto.getIdProjeto());
			
			in.execute();
		}
	}
	
	/**Verificar como retornar a chave estrangeira**/
	
	public static List<Projeto> listar() throws Exception {
		
		String sql = "SELECT * FROM projeto";
		
		List<Projeto> resultados = new ArrayList<Projeto>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Projeto projeto = new Projeto();
				
				projeto.setIdProjeto(res.getInt("idProjeto"));
				projeto.setNomeProjeto(res.getString("nomeProjeto"));
				projeto.setDescricaoProjeto(res.getString("descricaoProjeto"));
				projeto.setValorProjeto(res.getDouble("valorProjeto"));
				projeto.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				projeto.setAvaliacao(res.getInt("avaliacao"));
				projeto.setObservacaoAvaliacao(res.getString("observacaoAvaliacao"));
				
				/**projeto.setFreelancer(res.setIdFreelancer("idFreelancer"));**/
							
				resultados.add(projeto);
			}
		}
		
		return resultados;
	}
	
	/**Verificar como retornar a chave estrangeira**/
	public static List<Projeto> pesquisar(String nomeProjeto) throws Exception{
		
		String sql = "SELECT * FROM projeto WHERE nomeProjeto like ?";
		
		List<Projeto> resultados = new ArrayList<Projeto>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, "%" + nomeProjeto + "%");
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Projeto projeto = new Projeto();
				
				projeto.setIdProjeto(res.getInt("idProjeto"));
				projeto.setNomeProjeto(res.getString("nomeProjeto"));
				projeto.setDescricaoProjeto(res.getString("descricaoProjeto"));
				projeto.setValorProjeto(res.getDouble("valorProjeto"));
				projeto.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				projeto.setAvaliacao(res.getInt("avaliacao"));
				projeto.setObservacaoAvaliacao(res.getString("observacaoAvaliacao"));
				
				resultados.add(projeto);
			}
		}
		
		return resultados;
	}


}
