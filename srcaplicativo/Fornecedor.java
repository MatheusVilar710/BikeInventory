package gerenciadorestoque;

public class Fornecedor {
    public String nome;
    public String contato;

    public Fornecedor(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Contato: " + contato;
    }
}
