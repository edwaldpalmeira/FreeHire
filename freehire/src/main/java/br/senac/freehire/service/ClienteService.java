package br.senac.freehire.service;

import java.util.List;

import br.senac.freehire.dao.DAOCliente;
import br.senac.freehire.model.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("cliente")
public class ClienteService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cliente cliente) {
		try {
			DAOCliente.inserir(cliente);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Cliente cliente) {
		try {
			DAOCliente.atualizar(cliente);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int idCliente) {
		try {
			DAOCliente.excluir(idCliente);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar(){
		try {
			return DAOCliente.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Cliente> pesquisar(@QueryParam("cpf") String cpf){
		try {
			return DAOCliente.pesquisar(cpf);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
