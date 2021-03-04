package GerenciadorDeTarefas.model;

public enum Prioridade {
	BAIXA("Baixa"), 
	NORMAL("Normal"), 
	ALTA("Alta");

	private String label;

	private Prioridade(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
