package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Freelancer;
import br.senac.freehire.model.Proposta;
import br.senac.freehire.model.Servico;

public class DAOProposta {

	public static void inserir(Proposta proposta) throws Exception {

		String sql = "INSERT INTO proposta (descricaoProposta, dataProposta, dataAvaliacao, valorProposta, valorAvaliacao,"
				+ "observacaoProposta, idServico, idFrellancer)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, proposta.getDescricaoProposta());
			in.setString(2, proposta.getDataProposta());
			in.setString(3, proposta.getDataAvaliacao());
			in.setDouble(4, proposta.getValorProposta());
			in.setDouble(5, proposta.getValorAvaliacao());
			in.setString(6, proposta.getObservacaoProposta());
			in.setInt(7, proposta.getServico().getIdServico());
			in.setInt(8, proposta.getFreelancer().getIdFreelancer());

			in.execute();
		}
	}

	public static void excluir(int idProposta) throws Exception {
		String sql = "DELETE FROM proposta WHERE idProposta = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setInt(1, idProposta);

			in.execute();
		}
	}

	public static void atualizar(Proposta proposta) throws Exception {

		String sql = "UPDATE proposta SET descricaoProposta = ?, dataProposta  = ?, dataAvaliacao = ?,"
				+ " valorProposta  = ?, valorAvaliacao = ?, observacaoProposta  = ?, idServico = ?"
				+ " idFreelancer = ?, WHERE idProposta = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, proposta.getDescricaoProposta());
			in.setString(2, proposta.getDataProposta());
			in.setString(3, proposta.getDataAvaliacao());
			in.setDouble(4, proposta.getValorProposta());
			in.setDouble(5, proposta.getValorAvaliacao());
			in.setString(6, proposta.getObservacaoProposta());
			in.setInt(7, proposta.getServico().getIdServico());
			in.setInt(8, proposta.getFreelancer().getIdFreelancer());
			in.setInt(9, proposta.getIdProposta());

			in.execute();
		}
	}

	public static List<Proposta> listar() throws Exception {

		String sql = "SELECT p.descricaoProposta, p.dataProposta, p.dataAvaliacao, p.valorProposta"
				+ "p.valorAvaliacao, p.observacaoProposta, s.idServico, s.nomeServico, f.idFreelancer, "
				+ "f.free_nome * FROM proposta p inner join servico s on p.idProposta = s.idServico"
				+ "inner join freelancer f on p.idFreelancer = f.idFreelancer";

		List<Proposta> resultados = new ArrayList<Proposta>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Proposta proposta = new Proposta();

				proposta.setIdProposta(res.getInt("idProposta"));
				proposta.setDescricaoProposta(res.getString("descricaoProposta"));
				proposta.setDataProposta(res.getString("dataProposta"));
				proposta.setDataAvaliacao(res.getString("dataAvaliacao"));
				proposta.setValorProposta(res.getDouble("valorProposta"));
				proposta.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				proposta.setObservacaoProposta(res.getString("observacaoProposta"));

				Servico servico = new Servico();
				servico.setIdServico(res.getInt("idServico"));
				servico.setNomeServico(res.getString("nomeServico"));				
				proposta.setServico(servico);
				
				Freelancer freelancer = new Freelancer();
				freelancer.setIdFreelancer(res.getInt("idFreelancer"));
				freelancer.setNome(res.getString("free_nome"));
				proposta.setFreelancer(freelancer);

				resultados.add(proposta);
			}
		}

		return resultados;
	}

	public static List<Proposta> pesquisar(int idProposta) throws Exception {

		String sql = "SELECT * FROM proposta p inner join servico s on p.idProposta = s.idServico "
				+ "inner join freelancer f on p.idFreelancer = f.idFreelancer WHERE idProposta like ?";

		List<Proposta> resultados = new ArrayList<Proposta>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, "%" + idProposta + "%");

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Proposta proposta = new Proposta();

				proposta.setIdProposta(res.getInt("idProposta"));
				proposta.setDescricaoProposta(res.getString("descricaoProposta"));
				proposta.setDataProposta(res.getString("dataProposta"));
				proposta.setDataAvaliacao(res.getString("dataAvaliacao"));
				proposta.setValorProposta(res.getDouble("valorProposta"));
				proposta.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				proposta.setObservacaoProposta(res.getString("observacaoProposta"));

				Servico servico = new Servico();
				servico.setIdServico(res.getInt("idServico"));
				proposta.setServico(servico);
				
				Freelancer freelancer = new Freelancer();
				freelancer.setIdFreelancer(res.getInt("idFreelancer"));
				proposta.setFreelancer(freelancer);

				resultados.add(proposta);
			}
		}

		return resultados;
	}

}
