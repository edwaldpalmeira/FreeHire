package br.senac.freehire.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senac.freehire.Banco;
import br.senac.freehire.model.Proposta;

public class DAOProposta {
	
	/**tirar duvida sobre a forma de inserir a chave estrangeira**/
	
	public static void inserir(Proposta proposta) throws Exception {
		
		String sql = "INSERT INTO proposta (descricaoProposta, dataProposta, valorProposta, observacaoProposta)"
				+ " VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, proposta.getDescricaoProposta());
			in.setDate(2, new java.sql.Date(proposta.getDataProposta().getTime()));
			in.setDouble(3, proposta.getValorProposta());
			in.setString(4, proposta.getObservacaoProposta());
			
			in.execute();
		}
	}
	
	public static void excluir(int idProposta) throws Exception {
		String sql = "DELETE FROM proposta WHERE idProposta = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setInt(1, idProposta);
			
			in.execute();
		}
	}
	
	
	public static void atualizar(Proposta proposta) throws Exception {
		
		String sql = "UPDATE proposta SET descricaoProposta = ?, dataProposta  = ?, valorProposta  = ?, "
				+ "observacaoProposta  = ? WHERE idProposta = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, proposta.getDescricaoProposta());
			in.setDate(2, (Date) proposta.getDataProposta());
			in.setDouble(3, proposta.getValorProposta());
			in.setString(4, proposta.getObservacaoProposta());
			in.setInt(5, proposta.getIdProposta());
			
			in.execute();
		}
	}
	
	/**Verificar como retornar a chave estrangeira**/
	
	public static List<Proposta> listar() throws Exception {
		
		String sql = "SELECT * FROM proposta";
		
		List<Proposta> resultados = new ArrayList<Proposta>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Proposta proposta = new Proposta();
				
				proposta.setIdProposta(res.getInt("idProposta"));
				proposta.setDescricaoProposta(res.getString("descricaoProposta"));
				proposta.setDataProposta(res.getDate("dataProposta"));
				proposta.setValorProposta(res.getDouble("valorProposta"));
				proposta.setObservacaoProposta(res.getString("valorAvaliacao"));
				
				/**projeto.setCliente(res.setIdCliente("idCliente"));**/
				/**projeto.setProjeto(res.setProjeto("idProjeto"));**/
							
				resultados.add(proposta);
			}
		}
		
		return resultados;
	}
	
	/**Verificar como retornar a chave estrangeira**/
	public static List<Proposta> pesquisar(int idProposta) throws Exception{
		
		String sql = "SELECT * FROM proposta WHERE idProposta like ?";
		
		List<Proposta> resultados = new ArrayList<Proposta>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, "%" + idProposta + "%");
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Proposta proposta = new Proposta();
				
				proposta.setIdProposta(res.getInt("idProposta"));
				proposta.setDescricaoProposta(res.getString("descricaoProposta"));
				proposta.setDataProposta(res.getDate("dataProposta"));
				proposta.setValorProposta(res.getDouble("valorProposta"));
				proposta.setObservacaoProposta(res.getString("valorAvaliacao"));
				
				/**projeto.setCliente(res.setIdCliente("idCliente"));**/
				/**projeto.setProjeto(res.setProjeto("idProjeto"));**/
							
				resultados.add(proposta);
			}
		}
		
		return resultados;
	}


}
