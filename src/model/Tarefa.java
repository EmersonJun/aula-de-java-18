package model;

public class Tarefa {
    private int id;
    private String descricao;
    private StatusEnum status;

    public Tarefa(int id, String descricao, StatusEnum status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public static Tarefa criar(int id, String descricao, StatusEnum status){
        return new Tarefa(id, descricao, status);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", descricao=" + descricao + ", status=" + status + "]";
    }

    
}
