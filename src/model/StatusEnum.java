package model;

public enum StatusEnum {
    PENDENTE(1, "pendente"),
    EM_ANDAMENTO(2, "em andamento"),
    CONCLUIDO(3, "concluido");
    
    private int id;
    private String nome;
    
    private StatusEnum(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public static StatusEnum obterEnumPorId(int id){
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("enum invalido");
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
