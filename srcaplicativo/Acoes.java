package gerenciadorestoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Acoes  {
    private List<Item> estoque;
    private List<Fornecedor> fornecedores;
    private Scanner scanner;

    public Acoes() {
        estoque = new ArrayList<>();
        fornecedores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void executar() {
        while (true) {
            System.out.println("\nGerenciamento de Estoque");
            System.out.println("1. Cadastrar Item");
            System.out.println("2. Listar Itens");
            System.out.println("3. Atualizar Item");
            System.out.println("4. Cadastrar Fornecedor");
            System.out.println("5. Listar Fornecedores");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: { // Cadastrar Item
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Fornecedor: ");
                    String fornecedorNome = scanner.nextLine();

                    Fornecedor fornecedor = null;
                    for (Fornecedor f : fornecedores) {
                        if (f.nome.equalsIgnoreCase(fornecedorNome)) {
                            fornecedor = f;
                            break;
                        }
                    }
                    if (fornecedor == null) {
                        System.out.println("Fornecedor não encontrado. Cadastre o fornecedor primeiro.");
                    } else {
                        Item novoItem = new Item(codigo, nome, quantidade, fornecedor);
                        if (novoItem.validarCadastro()) {
                            estoque.add(novoItem);
                            System.out.println("Item cadastrado com sucesso!");
                        } else {
                            System.out.println("Erro ao cadastrar item. Verifique os dados informados.");
                        }
                    }
                    break;
                }

                case 2: { // Listar Itens
                    if (estoque.isEmpty()) {
                        System.out.println("Nenhum item cadastrado.");
                    } else {
                        System.out.println("\nItens em Estoque:");
                        for (Item item : estoque) {
                            System.out.println(item); // Usa o método toString() para exibir o item
                        }
                    }
                    break;
                }

                case 3: { // Atualizar Item
                    System.out.print("Código do item a atualizar: ");
                    String codigoAtualizar = scanner.nextLine();
                    for (Item item : estoque) {
                        if (item.codigo.equals(codigoAtualizar)) {
                            System.out.print("Nova quantidade: ");
                            int novaQuantidade = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            item.quantidade = novaQuantidade;
                            System.out.println("Item atualizado com sucesso!");
                            break;
                        }
                    }
                    if (!estoque.stream().anyMatch(item -> item.codigo.equals(codigoAtualizar))) {
                        System.out.println("Item não encontrado.");
                    }
                    break;
                }

                case 4: { // Cadastrar Fornecedor
                    System.out.print("Nome do Fornecedor: ");
                    String nomeFornecedor = scanner.nextLine();
                    System.out.print("Contato do Fornecedor: ");
                    String contatoFornecedor = scanner.nextLine();
                    fornecedores.add(new Fornecedor(nomeFornecedor, contatoFornecedor));
                    System.out.println("Fornecedor cadastrado com sucesso!");
                    break;
                }

                case 5: { // Listar Fornecedores
                    if (fornecedores.isEmpty()) {
                        System.out.println("Nenhum fornecedor cadastrado.");
                    } else {
                        System.out.println("\nFornecedores Cadastrados:");
                        for (Fornecedor fornecedor : fornecedores) {
                            System.out.println(fornecedor); // Usa o método toString() para exibir o fornecedor
                        }
                    }
                    break;
                }

                case 0: // Sair
                    System.out.println("Saindo do sistema...");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
