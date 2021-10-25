package br.senac.freehire.service;

import java.util.List;
import br.senac.freehire.dao.DAOProjeto;
import br.senac.freehire.model.Projeto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("projeto")
public class ProjetoService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Projeto projeto) {
		try {
			DAOProjeto.inserir(projeto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Projeto projeto) {
		try {
			DAOProjeto.atualizar(projeto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int idProjeto) {
		try {
			DAOProjeto.excluir(idProjeto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Projeto> listar(){
		try {
			return DAOProjeto.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Projeto> pesquisar(@QueryParam("nome") String nomeProjeto){
		try {
			return DAOProjeto.pesquisar(nomeProjeto);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
