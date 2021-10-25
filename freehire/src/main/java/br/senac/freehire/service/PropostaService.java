package br.senac.freehire.service;

import java.util.List;
import br.senac.freehire.dao.DAOProposta;
import br.senac.freehire.model.Proposta;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("proposta")
public class PropostaService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Proposta proposta) {
		try {
			DAOProposta.inserir(proposta);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Proposta proposta) {
		try {
			DAOProposta.atualizar(proposta);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int idProposta) {
		try {
			DAOProposta.excluir(idProposta);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Proposta> listar(){
		try {
			return DAOProposta.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Proposta> pesquisar(@QueryParam("idProposta") int idProposta){
		try {
			return DAOProposta.pesquisar(idProposta);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
