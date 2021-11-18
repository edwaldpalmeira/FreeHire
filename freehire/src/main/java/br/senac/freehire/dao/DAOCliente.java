package br.senac.freehire.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.senac.freehire.Banco;
import br.senac.freehire.model.Cliente;

public class DAOCliente {

	public static void inserir(Cliente cliente) throws Exception {

		String sql = "INSERT INTO cliente (cli_login, cli_senha, cli_nome, cli_cpf, cli_dataDeNascimento, cli_rua,"
				+ " cli_numero, cli_bairro, cli_cidade, cli_uf, cli_cep, cli_telefone, cli_email, cli_avaliacao,"
				+ "cli_observacaoAvaliacao)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, cliente.getLogin());
			in.setString(2, cliente.getSenha());
			in.setString(3, cliente.getNome());
			in.setString(4, cliente.getCpf());
			in.setString(5, cliente.getDataDeNascimento());
			in.setString(6, cliente.getRua());
			in.setString(7, cliente.getNumero());
			in.setString(8, cliente.getBairro());
			in.setString(9, cliente.getCidade());
			in.setString(10, cliente.getUf());
			in.setString(11, cliente.getCep());
			in.setString(12, cliente.getTelefone());
			in.setString(13, cliente.getEmail());
			in.setInt(14, cliente.getAvaliacao());
			in.setString(15, cliente.getObservacaoAvaliacao());

			in.execute();
		}
	}

	public static void excluir(int idCliente) throws Exception {
		String sql = "DELETE FROM cliente WHERE idCliente = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setInt(1, idCliente);

			in.execute();
		}
	}

	public static void atualizar(Cliente cliente) throws Exception {

		String sql = "UPDATE cliente SET cli_login = ?, cli_senha = ?, cli_nome = ?, cli_cpf = ?, cli_dataDeNascimento = ?,"
				+ "cli_rua = ?, cli_bairro = ?, cli_cidade = ?, cli_uf = ?, cli_numero = ?, cli_cep = ?, "
				+ "cli_telefone = ?, cli_email = ?, cli_avaliacao = ?, cli_observacaoAvaliacao = ? "
				+ "WHERE idCliente = ?";

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, cliente.getLogin());
			in.setString(2, cliente.getSenha());
			in.setString(3, cliente.getNome());
			in.setString(4, cliente.getCpf());
			in.setString(5, cliente.getDataDeNascimento());
			in.setString(6, cliente.getRua());
			in.setString(7, cliente.getNumero());
			in.setString(8, cliente.getBairro());
			in.setString(9, cliente.getCidade());
			in.setString(10, cliente.getUf());
			in.setString(11, cliente.getCep());
			in.setString(12, cliente.getTelefone());
			in.setString(13, cliente.getEmail());
			in.setInt(14, cliente.getAvaliacao());
			in.setString(15, cliente.getObservacaoAvaliacao());
			in.setInt(16, cliente.getIdCliente());

			in.execute();
		}
	}

	public static List<Cliente> listar() throws Exception {

		String sql = "SELECT * FROM cliente";

		List<Cliente> resultados = new ArrayList<Cliente>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Cliente cliente = new Cliente();

				cliente.setIdCliente(res.getInt("idCliente"));
				cliente.setLogin(res.getString("cli_login"));
				cliente.setSenha(res.getString("cli_senha"));
				cliente.setNome(res.getString("cli_nome"));
				cliente.setCpf(res.getString("cli_cpf"));
				cliente.setDataDeNascimento(res.getString("cli_dataDeNascimento"));
				cliente.setRua(res.getString("cli_rua"));
				cliente.setNumero(res.getString("cli_numero"));
				cliente.setBairro(res.getString("cli_bairro"));
				cliente.setCidade(res.getString("cli_cidade"));
				cliente.setUf(res.getString("cli_uf"));
				cliente.setCep(res.getString("cli_cep"));
				cliente.setTelefone(res.getString("cli_telefone"));
				cliente.setEmail(res.getString("cli_email"));
				cliente.setAvaliacao(res.getInt("cli_avaliacao"));
				cliente.setObservacaoAvaliacao(res.getString("cli_observacaoAvaliacao"));

				resultados.add(cliente);
			}
		}

		return resultados;
	}

	public static List<Cliente> pesquisar(String cpf) throws Exception {

		String sql = "SELECT * FROM cliente WHERE cli_cpf like ?";

		List<Cliente> resultados = new ArrayList<Cliente>();

		try (PreparedStatement in = Banco.connect().prepareStatement(sql)) {

			in.setString(1, "%" + cpf + "%");

			ResultSet res = in.executeQuery();

			while (res.next()) {

				Cliente cliente = new Cliente();

				cliente.setIdCliente(res.getInt("idCliente"));
				cliente.setLogin(res.getString("cli_login"));
				cliente.setSenha(res.getString("cli_senha"));
				cliente.setNome(res.getString("cli_nome"));
				cliente.setCpf(res.getString("cli_cpf"));
				cliente.setDataDeNascimento(res.getString("cli_dataDeNascimento"));
				cliente.setRua(res.getString("cli_rua"));
				cliente.setNumero(res.getString("cli_numero"));
				cliente.setBairro(res.getString("cli_bairro"));
				cliente.setCidade(res.getString("cli_cidade"));
				cliente.setUf(res.getString("cli_uf"));
				cliente.setCep(res.getString("cli_cep"));
				cliente.setTelefone(res.getString("cli_telefone"));
				cliente.setEmail(res.getString("cli_email"));
				cliente.setAvaliacao(res.getInt("cli_avaliacao"));
				cliente.setObservacaoAvaliacao(res.getString("cli_observacaoAvaliacao"));

				resultados.add(cliente);
			}
		}

		return resultados;
	}

}
