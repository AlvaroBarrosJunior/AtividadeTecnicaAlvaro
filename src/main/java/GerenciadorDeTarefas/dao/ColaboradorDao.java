package GerenciadorDeTarefas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import GerenciadorDeTarefas.model.Colaborador;
import GerenciadorDeTarefas.model.JPAUtil;

public class ColaboradorDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Metodo para cadastrar um novo colaborador
	public void cadastrarColaborador(Colaborador colaborador) {
		entity.getTransaction().begin();
		entity.persist(colaborador);
		entity.getTransaction().commit();
	}
	
	//Método para buscar todos os colaboradores
	@SuppressWarnings("unchecked")
	public List<Colaborador> buscarColaboradores() {
		List<Colaborador> listaDeColaboradores = new ArrayList<>();
		Query query = entity.createQuery("SELECT colaborador FROM Colaborador colaborador");
		listaDeColaboradores = query.getResultList();
		return listaDeColaboradores;
	}
	
	//Método para buscar colaborador por id 
	public Colaborador buscarColaboradorPorId(Long id) {
		Colaborador colaborador = new Colaborador();
		colaborador = entity.find(Colaborador.class, id);
		return colaborador;
	}
	
	
	//Método para editar um colaborador
	public void editarColaborador(Colaborador colaborador) {
		entity.getTransaction().begin();
		entity.merge(colaborador);
		entity.getTransaction().commit();
	}
	
	//Método para deletar um colaborador
	public void deletarColaborador(Long id) {
		Colaborador colaborador = new Colaborador();
		colaborador = entity.find(Colaborador.class, id);
		entity.getTransaction().begin();
		entity.remove(colaborador);
		entity.getTransaction().commit();
	}
}
