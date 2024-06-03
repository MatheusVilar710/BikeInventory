package gerenciadorestoque;

public class Item {
    public String codigo;
    public String nome;
    public int quantidade;
    public Fornecedor fornecedor;

    public Item(String codigo, String nome, int quantidade, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public boolean validarCadastro() {
        return codigo != null && !codigo.isEmpty() &&
               nome != null && !nome.isEmpty() &&
               quantidade >= 0 &&
               fornecedor != null; 
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Fornecedor: " + fornecedor.nome;
    }
}
