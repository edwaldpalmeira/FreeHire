package br.senac.freehire.service;

import java.util.List;
import br.senac.freehire.dao.DAOServico;
import br.senac.freehire.model.Servico;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("servico")
public class ServicoService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Servico servico) {
		try {
			DAOServico.inserir(servico);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Servico servico) {
		try {
			DAOServico.atualizar(servico);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int idServico) {
		try {
			DAOServico.excluir(idServico);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Servico> listar(){
		try {
			return DAOServico.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Servico> pesquisar(@QueryParam("nome") String nomeServico){
		try {
			return DAOServico.pesquisar(nomeServico);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
