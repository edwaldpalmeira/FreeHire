package br.senac.freehire.model;

public class Servico {

	private int idServico;
	private String nomeServico;
	private String descricaoServico;
	private Double valorServico;
	private Double valorAvaliacao;
	private String observacaoServico;
	private Cliente cliente = new Cliente();

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public Double getValorAvaliacao() {
		return valorAvaliacao;
	}

	public void setValorAvaliacao(Double valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}


	public String getObservacaoServico() {
		return observacaoServico;
	}

	public void setObservacaoServico(String observacaoServico) {
		this.observacaoServico = observacaoServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
