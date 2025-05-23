package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
    private static final String CAMINHO = "src/dados/usuario";
    public static void salvar(List<Usuario> ususarios) throws IOException{
        File diretorio = new File(CAMINHO);
        diretorio.mkdirs();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO +  "/usuarios.ser"))) {
            oos.writeObject(ususarios);
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Usuario> carregar() throws IOException, ClassNotFoundException{
        File arquivo = new File(CAMINHO + "/usuarios.ser");
        if (!arquivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Usuario>) this.readObject();
        }
    }
}
