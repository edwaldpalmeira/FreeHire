package br.senac.freehire.model;

import java.util.Date;

public class Proposta {
	
	private int idProposta;
	private String descricaoProposta;
	private Date dataProposta;
	private Double valorProposta;
	private String observacaoProposta;
	private Projeto projeto;
	private Cliente cliente;
	
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
	public Date getDataProposta() {
		return dataProposta;
	}
	public void setDataProposta(Date dataProposta) {
		this.dataProposta = dataProposta;
	}
	public Double getValorProposta() {
		return valorProposta;
	}
	public void setValorProposta(Double valorProposta) {
		this.valorProposta = valorProposta;
	}
	public String getObservacaoProposta() {
		return observacaoProposta;
	}
	public void setObservacaoProposta(String observacaoProposta) {
		this.observacaoProposta = observacaoProposta;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
