package br.senac.freehire.service;

import java.util.List;
import br.senac.freehire.dao.DAOUsuario;
import br.senac.freehire.model.Usuario;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("usuario")
public class UsuarioService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public static void inserir(Usuario usuario) {
		try {
			DAOUsuario.inserir(usuario);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public static void atualizar(Usuario usuario) {
		try {
			DAOUsuario.atualizar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public static void excluir(@QueryParam("id") int idUsuario) {
		try {
			DAOUsuario.excluir(idUsuario);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Usuario> pesquisar(@QueryParam("id") int idUsuario){
		try {
			return DAOUsuario.pesquisar(idUsuario);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Usuario> listar(){
		try {
			return DAOUsuario.listar();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

}
