package entities;

import conexao.Conexao;
import conexao.ConexaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    private final Conexao conexao;
    
    public ProdutoDAO() {
        this.conexao = new ConexaoMysql();
    }
    
    public String salvarProduto(Produto produto){
        return produto.getId() == null? cadastrarProduto(produto): editarProduto(produto);
    }
    
    private String cadastrarProduto(Produto produto){
        String sql = "insert into produto (nome,preco,estoque) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            preencherValores(preparedStatement,produto);
            preparedStatement.executeUpdate();
            return "Produto cadastrado com sucesso";
        } catch (SQLException e) {
            return String.format("Error: %s",e.getMessage());
        }      
    }
    
    private String editarProduto(Produto produto){
        String sql = "update produto nome=?,preco=?,estoque=?";
        try {
            PreparedStatement preparedStatement= conexao.obterConexao().prepareStatement(sql);
            preencherValores(preparedStatement, produto);
            preparedStatement.executeUpdate();
            return "Produto editado com sucesso";
        } catch (SQLException e) {
            return String.format("Error: %s",e.getMessage());
        }
    }
    
    private void preencherValores(PreparedStatement preparedStatement, Produto produto) throws SQLException {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.setInt(3, produto.getEstoque());
    }
    
    public List<Produto> listaDeProdutosCadastrados(){
        String sql = "select * from produto";
        List<Produto> listaDeProdutos = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            while(result.next()){
                listaDeProdutos.add(getProduto(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return listaDeProdutos;
    }
    
    public String exibirListaDeProdutos(){
        String sql = "select * from produto";
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            StringBuilder sb = new StringBuilder();                   
            while(result.next()){
                sb.append(getProduto(result)).append("\n");              
            }
            return sb.toString();
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return "";
    }
    
    
     private Produto getProduto(ResultSet resultado) throws SQLException{
        Produto produto = new Produto();
        
        produto.setId(resultado.getInt("id"));
        produto.setNome(resultado.getString("nome"));
        produto.setPreco(resultado.getDouble("preco"));
        produto.setEstoque(resultado.getInt("estoque"));
        
        return produto;
    }
     
     public Produto buscarProdutoPorId(int id){
         String sql = String.format("select * from produto where id = %d",id);
         try {
             ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
             while(result.next()){
                 return getProduto(result);
             }
         } catch (SQLException e) {
             System.out.println(String.format("Error: %s", e.getMessage()));                
        }
        return null;
     }
     
     public Produto buscarProdutoPorNome(String nome){
         String sql = String.format("select * from produto where nome = %s", nome);
         try {
             ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
             while(result.next()){
                return getProduto(result);
             }                  
         } catch (SQLException e) {
             System.out.println(String.format("Error: %s", e.getMessage()));
         }
         return null;
     }
     
     public void deletarProduto(int id){
         String sql = String.format("delete from produto where id = %d",id);
         Produto p = buscarProdutoPorId(id);
         if(p==null){
             System.out.println("Produto não encontrado");
             return;
         }
         try {
            PreparedStatement preparedStatement= conexao.obterConexao().prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("Produto deletado com sucesso");
         } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
         }
     }
}
