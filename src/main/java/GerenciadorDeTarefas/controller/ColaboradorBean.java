package GerenciadorDeTarefas.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import GerenciadorDeTarefas.dao.ColaboradorDao;
import GerenciadorDeTarefas.model.Colaborador;

@ManagedBean(name = "colaboradorBean")
@RequestScoped
public class ColaboradorBean {
	private String Nome;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Colaborador> getColaboradores() {
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		return colaboradorDao.buscarColaboradores();
	}

	public void deletarColaborador(Long id) throws PSQLException {
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		try {			
			colaboradorDao.deletarColaborador(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Colaborador não pode ser excluído pois é responsável por alguma tarefa.\n "
					+ "Edite ou exclua a tarefa para poder excluir esse colaborador!","alert" , JOptionPane.ERROR_MESSAGE);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/colaboradores.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrarColaborador() {
		ColaboradorDao colaboradorDao = new ColaboradorDao();
		Colaborador colaborador = new Colaborador();
		
		colaborador.setNome(Nome);
		colaboradorDao.cadastrarColaborador(colaborador);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorDeTarefas/faces/colaboradores.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
