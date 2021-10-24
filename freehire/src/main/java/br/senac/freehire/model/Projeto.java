package br.senac.freehire.model;

public class Projeto {
	
	private int idProjeto;
	private String nomeProjeto;
	private String descricaoProjeto;
	private Double valorProjeto;
	private Double valorAvaliacao;
	private int avaliacao;
	private String observacaoAvaliacao;
	private Freelancer freelancer;
	
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}
	public void setDescricaoProjeto(String descricaoProjeto) {
		this.descricaoProjeto = descricaoProjeto;
	}
	public Double getValorProjeto() {
		return valorProjeto;
	}
	public void setValorProjeto(Double valorProjeto) {
		this.valorProjeto = valorProjeto;
	}
	public Double getValorAvaliacao() {
		return valorAvaliacao;
	}
	public void setValorAvaliacao(Double valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getObservacaoAvaliacao() {
		return observacaoAvaliacao;
	}
	public void setObservacaoAvaliacao(String observacaoAvaliacao) {
		this.observacaoAvaliacao = observacaoAvaliacao;
	}
	public Freelancer getFreelancer() {
		return freelancer;
	}
	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	
}
