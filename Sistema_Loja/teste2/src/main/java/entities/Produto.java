
package entities;

public class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(){
        
    }
    
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return   String.format("ID: %d - Produto: %s - Preço: %.2f - Estoque: %d ", 
                getId(),getNome(),getPreco(),getEstoque());
        
    }
   
    
}
