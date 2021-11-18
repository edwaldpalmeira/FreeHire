package br.senac.freehire.model;

public class Proposta {

	private int idProposta;
	private String descricaoProposta;
	private String dataProposta;
	private String dataAvaliacao;
	private Double valorProposta;
	private Double valorAvaliacao;
	private String observacaoProposta;
	private Servico servico;
	private Freelancer freelancer;

	public int getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(int idProposta) {
		this.idProposta = idProposta;
	}

	public String getDescricaoProposta() {
		return descricaoProposta;
	}

	public void setDescricaoProposta(String descricaoProposta) {
		this.descricaoProposta = descricaoProposta;
	}

	public String getDataProposta() {
		return dataProposta;
	}

	public void setDataProposta(String dataProposta) {
		this.dataProposta = dataProposta;
	}

	public String getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(String dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Double getValorProposta() {
		return valorProposta;
	}

	public void setValorProposta(Double valorProposta) {
		this.valorProposta = valorProposta;
	}

	public Double getValorAvaliacao() {
		return valorAvaliacao;
	}

	public void setValorAvaliacao(Double valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}

	public String getObservacaoProposta() {
		return observacaoProposta;
	}

	public void setObservacaoProposta(String observacaoProposta) {
		this.observacaoProposta = observacaoProposta;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

}
