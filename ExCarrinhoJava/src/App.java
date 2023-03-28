import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<ItemCompra> itensCompra = new ArrayList<ItemCompra>();

        FileInputStream arquivo = new FileInputStream("Lista.txt");
        InputStreamReader leitor = new InputStreamReader(arquivo, StandardCharsets.UTF_8); // para deixar a leitura mais
                                                                                           // // facil !
        BufferedReader linha = new BufferedReader(leitor);

        Scanner entrada = new Scanner(System.in);
        String aux = linha.readLine();
        while (aux != null) {
            String[] dados = aux.split(";");
            int codigo = Integer.parseInt(dados[0]);
            String descricao = dados[1];
            double preco = Double.parseDouble(dados[2]);
            Produto produto = new Produto(codigo, descricao, preco);
            produtos.add(produto);
            aux = linha.readLine();
        }
        linha.close();
        System.out.println("Arquivo carregado com sucesso!.");

        int codigoUsuario = -1;

        do {
            System.out.println("Informe o codigo do produto ou 99999 para finalizar.");
            codigoUsuario = entrada.nextInt();

            int flag = 0;
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).codigo == codigoUsuario) {
                    System.out.print("Informe  a quantidade desejada: ");
                    int qtde = entrada.nextInt();

                    ItemCompra item = new ItemCompra(produtos.get(i).getDescricao(), qtde,
                            produtos.get(i).getPreco());
                    if (item.qtde > 0) {
                        itensCompra.add(item);
                    }

                }
            }
            System.out.println("Item adicionado com sucesso!\n");

        } while (codigoUsuario != 99999);
        entrada.close();

        Carrinho carrinho = new Carrinho(itensCompra, 10);
        carrinho.mostraCarrinho();
    }

}
