package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.StatusEnum;
import model.Tarefa;
import model.Usuario;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController(List<Usuario> ususarios) {
        this.usuarios = ususarios;
    }

    public void criarUsuario(String nome){
        Usuario usuario = Usuario.cria(criarIdUsuario(), nome, new ArrayList<>());
        usuarios.add(usuario);
    }

    private int criarIdUsuario(){
        return usuarios.stream()
        .mapToInt(u -> u.getId())
        .max()
        .orElse(0) + 1;
    }

    public List<String> listarUsuarios(){
        return usuarios.stream()
        .map(u-> "#" + u.getId() + " " + u.getNome())
        .toList();
    }
    public Optional<Usuario> buscaUsuario(int id){
        return usuarios.stream()
        .filter(u -> u.getId() == id)
        .findFirst();
    }
        
    public void adicionarTarefa(int idUsuario, String descricao, StatusEnum status){
        buscaUsuario(idUsuario).ifPresentOrElse(
            u -> u.addTarefa(Tarefa.criar(idUsuario, descricao, status)),
         () -> new Exception("usuario nao encontrado"));
    }
}
