package GerenciadorDeTarefas.model;

import java.io.Serializable;

public interface Persistent extends Serializable {

    public Long getId();

    public String getLabel();

}
