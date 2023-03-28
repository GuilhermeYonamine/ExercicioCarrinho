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
        return descricao + "\t" + preco + "\t\t" + qtde + "\t\t\t" + calcSubtotal();
    }

    public double calcSubtotal() {
        return qtde * preco;
    }

}
