package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Cliente;
import br.senac.freehire.model.Servico;

public class DAOServico {

	public static void inserir(Servico servico) throws Exception {

		String sql = "INSERT INTO servico (nomeServico, descricaoServico, valorServico, valorAvaliacao, "
				+ "observacaoServico, idCliente) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, servico.getNomeServico());
			in.setString(2, servico.getDescricaoServico());
			in.setDouble(3, servico.getValorServico());
			in.setDouble(4, servico.getValorAvaliacao());
			in.setString(5, servico.getObservacaoServico());
			in.setInt(6, servico.getCliente().getIdCliente());

			in.execute();
		}
	}

	public static void excluir(int idServico) throws Exception {
		String sql = "DELETE FROM servico WHERE idServico = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setInt(1, idServico);

			in.execute();
		}
	}

	public static void atualizar(Servico servico) throws Exception {

		String sql = "UPDATE servico SET nomeServico = ?, descricaoServico = ?, valorServico = ?, "
				+ "valorAvaliacao = ?, observacaoServico = ? WHERE idServico = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, servico.getNomeServico());
			in.setString(2, servico.getDescricaoServico());
			in.setDouble(3, servico.getValorServico());
			in.setDouble(4, servico.getValorAvaliacao());
			in.setString(5, servico.getObservacaoServico());
			in.setInt(6, servico.getIdServico());

			in.execute();
		}
	}

	public static List<Servico> listar() throws Exception {

		String sql = "SELECT s.idServico, s.nomeServico, s.descricaoServico, s.valorServico, s.valorAvaliacao,"
				+ "s.observacaoServico, s.idCliente, c.Cli_nome "
				+ "FROM servico s inner join cliente c on c.idCliente = s.idCliente;";

		List<Servico> resultados = new ArrayList<Servico>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Servico servico = new Servico();

				servico.setIdServico(res.getInt("idServico"));
				servico.setNomeServico(res.getString("nomeServico"));
				servico.setDescricaoServico(res.getString("descricaoServico"));
				servico.setValorServico(res.getDouble("valorServico"));
				servico.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				servico.setObservacaoServico(res.getString("observacaoServico"));
				
				Cliente cliente = new Cliente();
				cliente.setIdCliente(res.getInt("idCliente"));
				cliente.setNome(res.getString("cli_nome"));
				
				servico.setCliente(cliente);

				resultados.add(servico);
			}
		}

		return resultados;
	}

	public static List<Servico> pesquisar(String nomeServico) throws Exception {

		String sql = "SELECT s.idServico, s.nomeServico, s.descricaoServico, s.valorServico, s.valorAvaliacao,"
				+ "s.observacaoServico, s.idCliente, c.Cli_nome "
				+ "FROM servico s inner join cliente c on c.idCliente = s.idCliente WHERE s.nomeServico like ?";

		List<Servico> resultados = new ArrayList<Servico>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, "%" + nomeServico + "%");

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Servico servico = new Servico();

				servico.setIdServico(res.getInt("idServico"));
				servico.setNomeServico(res.getString("nomeServico"));
				servico.setDescricaoServico(res.getString("descricaoServico"));
				servico.setValorServico(res.getDouble("valorServico"));
				servico.setValorAvaliacao(res.getDouble("valorAvaliacao"));
				servico.setObservacaoServico(res.getString("observacaoServico"));
				
				Cliente cliente = new Cliente();
				cliente.setIdCliente(res.getInt("idCliente"));
				cliente.setNome(res.getString("cli_nome"));
				
				servico.setCliente(cliente);

				resultados.add(servico);
			}
		}

		return resultados;
	}

}
