package com.salescorp.teste2;

import conexao.Conexao;
import conexao.ConexaoMysql;
import entities.Produto;
import entities.ProdutoDAO;
import entities.Usuario;
import entities.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wesle
 */
public class Teste2 {

    public static void main(String[] args) throws SQLException {
        Conexao conexao = new ConexaoMysql();
        
        Usuario novoUsuario = new Usuario("Novo", "Teste","WesleySales12", "4444");
//        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuarioDAO.salvarUsuario(novoUsuario);
        
        Usuario teste = usuarioDAO.buscarUsuarioPeloLogin("WesleySales12");
        System.out.println(teste.getNome());
                
//        Usuario usuario = usuarioDAO.BuscarUsuarioPeloNome("Joao Paulo");
//        Usuario usuario2 = usuarioDAO.buscarUsuarioPorId(1);
//        System.out.println(usuario.getNome());
//        System.out.println(usuario2.getNome());
//        
        
    }
}
