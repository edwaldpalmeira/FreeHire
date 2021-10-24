package br.senac.freehire.service;

import java.util.List;

import br.senac.freehire.dao.DAOFreelancer;
import br.senac.freehire.model.Freelancer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("freelancer")
public class FreelancerService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Freelancer freelancer) {
		try {
			DAOFreelancer.inserir(freelancer);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Freelancer freelancer) {
		try {
			DAOFreelancer.atualizar(freelancer);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int idFreelancer) {
		try {
			DAOFreelancer.excluir(idFreelancer);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Freelancer> pesquisar(@QueryParam("cpf") String cpf){
		try {
			return DAOFreelancer.pesquisar(cpf);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

}
