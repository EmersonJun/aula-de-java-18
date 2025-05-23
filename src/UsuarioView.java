import java.util.ArrayList;
import java.util.Scanner;

import controller.UsuarioController;
import model.StatusEnum;

public class UsuarioView {
    public static void menu(){
        UsuarioController controller = new UsuarioController(new ArrayList<>());
        try (Scanner in = new Scanner(System.in)) {
            boolean menu = true;

            while (menu) {
                System.out.println("---menu---");
                System.out.println("\n1 - cadastrar usuario");
                System.out.println("2 - listar usuarios");
                System.out.println("3 - adicionar tarefas ao usuario");
                System.out.println("4 - listar tarefas do usuario");
                System.out.println("0 - sair");

                int opcao = in.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("digite o nome do usuario");
                        controller.criarUsuario(in.nextLine());
                        break;
                    case 2:
                        controller.listarUsuarios().forEach(System.out::println);
                        break;
                    case 3:
                    try {
                        System.out.println("digite o id do usuario");
                        int idUsuario = in.nextInt();

                        System.out.println("insira a descricao da tarefa");
                        String descricao = in.nextLine();

                        System.out.println("status (1 - pendente, 2 - em andamento, 3 - concluido)");
                        int idStatus = in.nextInt();
                        controller.adicionarTarefa(idUsuario, descricao, StatusEnum.obterEnumPorId(idStatus));
                    } catch (Exception e) {
                        System.out.println("erro: "+ e.getMessage());
                    }
                        break;
                    case 4:
                        System.out.println("digite o id do usuario");
                        int idUsuario = in.nextInt();
                        controller.buscaUsuario(idUsuario).
                        ifPresentOrElse(u -> u.getTarefas().forEach(System.out::println), 
                        () -> System.out.println("usuario nao encontrado"));
                        break;
                    case 0:
                        System.out.println("saindo");
                        break;
                    default:
                        System.out.println("opcao invalida");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("erro ao iniciar o scanner");
        }
    }
}
