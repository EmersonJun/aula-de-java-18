package model;

import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private List<Tarefa> tarefas;

    private Usuario(int id, String nome, List<Tarefa> tarefas) {
        this.id = id;
        this.nome = nome;
        this.tarefas = tarefas;
    }
    public static Usuario cria(int id, String nome, List<Tarefa> tarefas){
        return new Usuario(id, nome, tarefas);
    }
    public int gerarIdTarefa(){
        return tarefas.stream()
        .mapToInt(null)
        .max()
        .orElse(0) + 1;
    }
    public void addTarefa(Tarefa tarefa){
        tarefa.setId(gerarIdTarefa());
        tarefas.add(tarefa);
    }
    public List<String> getTarefas(){
        return tarefas.stream()
        .map(t -> t.toString())
        .toList();
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", tarefas=" + tarefas + "]";
    }
}
