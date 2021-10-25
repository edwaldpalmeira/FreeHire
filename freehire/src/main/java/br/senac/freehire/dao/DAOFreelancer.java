package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Freelancer;

public class DAOFreelancer {
	
	public static void inserir(Freelancer freelancer) throws Exception {
		
		String sql = "INSERT INTO freelancer (free_nome, free_cpf, free_rua, free_bairro, free_cidade," 
				+ "free_uf, free_numero, free_cep, free_telefone, free_email, "
				+ "free_avaliacao, free_observacaoAvaliacao)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, freelancer.getNome());
			in.setString(2, freelancer.getCpf());
			in.setString(3, freelancer.getRua());
			in.setString(4, freelancer.getBairro());
			in.setString(5, freelancer.getCidade());
			in.setString(6, freelancer.getUf());
			in.setString(7, freelancer.getNumero());
			in.setString(8, freelancer.getCep());
			in.setString(9, freelancer.getTelefone());
			in.setString(10, freelancer.getEmail());
			in.setInt(11, freelancer.getAvaliacao());
			in.setString(12, freelancer.getObservacaoAvaliacao());
			
			in.execute();
		}
	}

	public static void excluir(int idFreelancer) throws Exception {
		
		String sql = "DELETE FROM freelancer WHERE idFreelancer = ?";
	
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
		
			in.setInt(1, idFreelancer);
		
			in.execute();
		}
	}
	
	public static void atualizar(Freelancer freelancer) throws Exception {
		
		String sql = "UPDATE freelancer SET free_nome = ?, free_cpf = ?, free_rua = ?, free_bairro = ?, free_cidade = ?,"
				+ "free_uf = ?, free_numero = ?, free_cep = ?, free_telefone = ?, free_email = ?,"
				+ "free_avaliacao = ?, free_observacaoAvaliacao = ? WHERE idFreelancer = ?";
		
		try (PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, freelancer.getNome());
			in.setString(2, freelancer.getCpf());
			in.setString(3, freelancer.getRua());
			in.setString(4, freelancer.getBairro());
			in.setString(5, freelancer.getCidade());
			in.setString(6, freelancer.getUf());
			in.setString(7, freelancer.getNumero());
			in.setString(8, freelancer.getCep());
			in.setString(9, freelancer.getTelefone());
			in.setString(10, freelancer.getEmail());
			in.setInt(11, freelancer.getAvaliacao());
			in.setString(12, freelancer.getObservacaoAvaliacao());
			in.setInt(13, freelancer.getIdFreelancer());
			
			in.execute();
		}
	}
	
	public static List<Freelancer> pesquisar(String cpf) throws Exception{
		
		String sql = "SELECT * FROM freelancer WHERE free_cpf like ?";
		
		List<Freelancer> resultados = new ArrayList<Freelancer>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			in.setString(1, "%" + cpf + "%");
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Freelancer freelancer = new Freelancer();
				
				freelancer.setIdFreelancer(res.getInt("idFreelancer"));
				freelancer.setNome(res.getString("free_nome"));
				freelancer.setCpf(res.getString("free_cpf"));
				freelancer.setRua(res.getString("free_rua"));
				freelancer.setBairro(res.getString("free_bairro"));
				freelancer.setCidade(res.getString("free_cidade"));
				freelancer.setUf(res.getString("free_uf"));
				freelancer.setNumero(res.getString("free_numero"));
				freelancer.setCep(res.getString("free_cep"));
				freelancer.setTelefone(res.getString("free_telefone"));
				freelancer.setEmail(res.getString("free_email"));
				freelancer.setAvaliacao(res.getInt("free_avaliacao"));
				freelancer.setObservacaoAvaliacao(res.getString("free_observacaoAvaliacao"));
				
				resultados.add(freelancer);
			}
		}
		
		return resultados;
	}
	
	public static List<Freelancer> listar() throws Exception {
		
		String sql = "SELECT * FROM freelancer";
		
		List<Freelancer> resultados = new ArrayList<Freelancer>();
		
		try(PreparedStatement in = Banco.connect().prepareStatement(sql)){
			
			ResultSet res = in.executeQuery();
			
			while(res.next()) {
				
				Freelancer freelancer = new Freelancer();
				
				freelancer.setIdFreelancer(res.getInt("idFreelancer"));
				freelancer.setNome(res.getString("free_nome"));
				freelancer.setCpf(res.getString("free_cpf"));
				freelancer.setRua(res.getString("free_rua"));
				freelancer.setBairro(res.getString("free_bairro"));
				freelancer.setCidade(res.getString("free_cidade"));
				freelancer.setUf(res.getString("free_uf"));
				freelancer.setNumero(res.getString("free_numero"));
				freelancer.setCep(res.getString("free_cep"));
				freelancer.setTelefone(res.getString("free_telefone"));
				freelancer.setEmail(res.getString("free_email"));
				freelancer.setAvaliacao(res.getInt("free_avaliacao"));
				freelancer.setObservacaoAvaliacao(res.getString("free_observacaoAvaliacao"));
				
				resultados.add(freelancer);
			}
		}
		
		return resultados;
	}
}
