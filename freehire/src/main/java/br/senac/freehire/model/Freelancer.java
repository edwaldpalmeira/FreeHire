package br.senac.freehire.model;

import java.util.Date;

public class Freelancer {
	
	private int idFreelancer;
	private String nome;
	private Date data_de_nascimento;
	private String cpf;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String numero;
	private String cep;
	private String telefone;
	private String email;
	private int avaliacao;
	private String observacaoAvaliacao;
	
	public int getIdFreelancer() {
		return idFreelancer;
	}
	public void setIdFreelancer(int idFreelancer) {
		this.idFreelancer = idFreelancer;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	
}
