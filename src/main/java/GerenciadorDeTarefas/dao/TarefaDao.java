package GerenciadorDeTarefas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import GerenciadorDeTarefas.model.Colaborador;
import GerenciadorDeTarefas.model.JPAUtil;
import GerenciadorDeTarefas.model.Prioridade;
import GerenciadorDeTarefas.model.Tarefa;

public class TarefaDao {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Método para cadastrar uma nova tarefa
	public void cadastrarTarefa(Tarefa tarefa) {
		tarefa.setSituacao("Em andamento");
		entity.getTransaction().begin();
		entity.persist(tarefa);
		entity.getTransaction().commit();
	}
	
	//Método para editar uma tarefa
	public void editarTarefa(Tarefa tarefa) {
		entity.getTransaction().begin();
		entity.merge(tarefa);
		entity.getTransaction().commit();
	}
	
	//Método para buscar tarefas
	@SuppressWarnings("unchecked")
	public List<Tarefa> buscarTarefas(String id, String texto, Colaborador responsavel, String situacao) {
		List<Tarefa> listaDeTarefas = new ArrayList<>();
		String sql = "SELECT tarefa FROM Tarefa tarefa";
		if (id != null && id != "") {sql = sql.concat(" ### id = " + id);};
		if (texto != null && texto != "") {sql = sql.concat(" ### titulo LIKE '%" + texto + "%' OR descricao LIKE '%" + texto + "%'");};
		if (situacao != null && situacao != "") {sql = sql.concat(" ### situacao LIKE '" + situacao+ "'");};
		if (responsavel != null) {sql = sql.concat(" ### responsavel.id = " + responsavel.getId());};
		sql = sql.concat(" ORDER BY id ASC");
		sql = sql.replaceFirst("###", "WHERE");
		sql = sql.replaceAll("###", "AND");
		Query query = entity.createQuery(sql);
		listaDeTarefas = query.getResultList();
		System.out.println(listaDeTarefas);
		return listaDeTarefas;
	}
	
	//Método para buscar tarefa por id
	public Tarefa buscarTarefaPorId(Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa = entity.find(Tarefa.class, id);
		return tarefa;
	}
	
	//Método para deletar uma tarefa
	public void deletarTarefa(Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa = entity.find(Tarefa.class, id);
		entity.getTransaction().begin();
		entity.remove(tarefa);
		entity.getTransaction().commit();
	}
		
}
