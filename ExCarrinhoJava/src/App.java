import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
        Set<Integer> codigosEstabelecidos = new HashSet<Integer>();

        FileReader data = new FileReader("Lista.txt");
        BufferedReader linha = new BufferedReader(data);
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
        System.out.println("Carregado com sucesso.");

        int codigoUsuario = -1;

        do {
            System.out.println("informe o codigo do produto ou 99999 para finalizar.");
            while (!entrada.hasNextInt()) {
                System.out.println("Código inválido");
                entrada.next();
            }
            codigoUsuario = entrada.nextInt();

            int flag = -1;

            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).codigo == codigoUsuario) {
                    System.out.print("informe  a quantidade desejada: ");

                    while (!entrada.hasNextInt()) {
                        System.out.println("Código inválido");
                        entrada.next();
                    }
                    int qtde = entrada.nextInt();
                    if (codigosEstabelecidos.contains(codigoUsuario)) {
                        int codigoI = 0;
                        for (int j = 0; j < codigosEstabelecidos.size(); j++) {
                            if (codigosEstabelecidos.contains(codigoUsuario)) {
                                codigoI = j;
                            }
                        }
                        int quantidade = itensCompra.get(codigoI).getQtde();
                        itensCompra.get(codigoI).setQtde(quantidade + qtde);
                        flag = i;
                        continue;
                    } else {
                        ItemCompra item = new ItemCompra(produtos.get(i).getDescricao(), qtde,
                                produtos.get(i).getPreco());
                        if (item.qtde > 0) {
                            itensCompra.add(item);
                        }
                        flag = i;
                    }
                    break;
                }
            }

        } while (codigoUsuario != 99999);
        entrada.close();

        Carrinho carrinho = new Carrinho(itensCompra, 10);
        carrinho.mostraCarrinho();
    }

}
