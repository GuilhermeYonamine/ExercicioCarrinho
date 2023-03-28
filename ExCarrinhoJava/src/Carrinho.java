import java.lang.reflect.Array;
import java.util.ArrayList;

public class Carrinho {
    ArrayList<ItemCompra> listaItens = new ArrayList<ItemCompra>();

    public double totalCompra, porcDesconto, valorPagar;

    public Carrinho(ArrayList<ItemCompra> listaItens, double porcDesconto) {
        this.listaItens = listaItens;
        this.totalCompra = 0;
        this.porcDesconto = porcDesconto;
        this.valorPagar = 0;

    }

    public void mostraCarrinho() {
        System.out.println(
                "Item" + "\t\t\t" + "descricao" + "\t\t\t\t" + "qtde" + "\t\t\t" + "preco" + "\t" + "sub total");
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println(i + "\t" + listaItens.get(i).mostraItem());
        }
        System.out.println("\n\t\t\t\t\t\t\t\tSubtotal: " + String.format("R$%.2f", somaValores()));
        System.out.println("\t\t\t\t\t\t\t\tdescontos " + String.format("R$%.2f", calcDesconto(somaValores())));
        System.out.println("\t\t\t\t\t\t\t\tTotal: " + String.format("R$%.2f", valorPagar()));
        System.out.println("\n");

    }

    public double calcDesconto(double totalCompra) {
        return totalCompra * (porcDesconto / 100);
    }

    public double somaValores() {
        double valorPagar = 0;
        for (ItemCompra item : listaItens) {
            valorPagar += item.calcSubtotal();
        }
        return valorPagar;
    }

    public double valorPagar() {
        return (somaValores() - calcDesconto(totalCompra));
    }

}
