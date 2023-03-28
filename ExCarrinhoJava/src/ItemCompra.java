import java.text.DecimalFormat;

public class ItemCompra {
    String descricao;
    int qtde;
    double preco;

    public ItemCompra(String descricao, int qtde, double preco) {
        this.descricao = descricao;
        this.qtde = qtde;
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtde() {
        return this.qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String mostraItem() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return descricao + "\t" + "R$" + df.format(preco) + "\t\t" + qtde + "\t\t\t" + df.format(calcSubtotal());
    }

    public double calcSubtotal() {
        return this.qtde * this.preco;
    }

}
