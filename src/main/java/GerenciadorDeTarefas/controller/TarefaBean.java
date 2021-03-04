package GerenciadorDeTarefas.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import GerenciadorDeTarefas.dao.TarefaDao;
import GerenciadorDeTarefas.model.Colaborador;
import GerenciadorDeTarefas.model.Prioridade;
import GerenciadorDeTarefas.model.Tarefa;

@ManagedBean(name = "tarefaBean")
@RequestScoped
public class TarefaBean {
	private Tarefa tarefa;

	private String id;

	private String texto;

	private Colaborador responsavel;

	private String situacao;

	private List<Tarefa> listaDeTarefas;

	public Tarefa getTarefa() {
		if (this.tarefa == null) {
			this.tarefa = new Tarefa();
		}
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Colaborador getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Colaborador responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Tarefa> getListaDeTarefas() {
		TarefaDao tarefaDao = new TarefaDao();
		return tarefaDao.buscarTarefas(id, texto, responsavel, situacao);
	}

	public void setListaDeTarefas(List<Tarefa> listaDeTarefas) {
		this.listaDeTarefas = listaDeTarefas;
	}

	// Método para filtrar a listagem de tarefas
	public void buscarTarefas() {
		TarefaDao tarefaDao = new TarefaDao();
		List<Tarefa> lista = tarefaDao.buscarTarefas(id, texto, responsavel, situacao);
		this.setListaDeTarefas(lista);
	}

	// Método para direcionar a página de atualização de tarefas
	public void paginaAtualizarTarefa(Long id) {
		TarefaDao tarefaDao = new TarefaDao();
		Tarefa tarefa = new Tarefa();
		tarefa = tarefaDao.buscarTarefaPorId(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("tarefa", tarefa);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/GerenciadorDeTarefas/faces/editar-tarefa.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para direcionar a página de ver detalhes da tarefa
	public void paginaDetalhesTarefa(Long id) {
		TarefaDao tarefaDao = new TarefaDao();
		Tarefa tarefa = new Tarefa();
		tarefa = tarefaDao.buscarTarefaPorId(id);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("tarefa", tarefa);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/GerenciadorDeTarefas/faces/detalhes-tarefa.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para direcionar a página de colaboradores
	public void paginaColaboradores() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/GerenciadorDeTarefas/faces/colaboradores.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para direcionar a página de listagem de tarefas
	public void paginaListagemDeTarefas() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para direcionar a pagina de cadastro de tarefas
	public void paginaCadastrarTarefa() {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/GerenciadorDeTarefas/faces/cadastrar-tarefa.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para atualizar a tarefa
	public void atualizarTarefa(Tarefa tarefa) {
		TarefaDao tarefaDao = new TarefaDao();
		tarefaDao.editarTarefa(tarefa);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para concluir a tarefa
	public void atualizarSituacaoTarefa(Tarefa tarefa) {
		TarefaDao tarefaDao = new TarefaDao();
		tarefa.setSituacao("Concluída");
		tarefaDao.editarTarefa(tarefa);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para deletar a tarefa
	public void deletarTarefa(Long id) {
		TarefaDao tarefaDao = new TarefaDao();
		tarefaDao.deletarTarefa(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método para cadastrar uma tarefa
	public void cadastrarTarefa() {
		TarefaDao tarefaDao = new TarefaDao();

		try {
			tarefaDao.cadastrarTarefa(tarefa);
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/GerenciadorDeTarefas/faces/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!", "alert",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<Prioridade> getPrioridadeList() {
		return Arrays.asList(Prioridade.values());
	}

}
