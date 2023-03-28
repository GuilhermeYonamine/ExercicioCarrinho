import java.util.*;

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
                "Item" + "\t\t\t" + "Descrição" + "\t\t\t\t" + "Qtde" + "\t\t\t" + "Preço" + "\t" + "Subtotal");
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println(i + "\t" + listaItens.get(i).mostraItem());
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("\n\t\t\t\t\t\t\t\tSubtotal: " + String.format("R$%.2f", somaValores()));
        System.out.println("\t\t\t\t\t\t\t\tDescontos: " + String.format("R$%.2f", calcDesconto(somaValores())));
        System.out.println("\t\t\t\t\t\t\t\tTotal: " + String.format("R$%.2f", valorPagar()));
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");

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
        double valor = somaValores() - calcDesconto(somaValores());
        return valor;
    }

}
