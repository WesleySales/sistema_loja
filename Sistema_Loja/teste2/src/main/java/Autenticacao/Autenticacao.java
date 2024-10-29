
package Autenticacao;

import entities.Usuario;
import entities.UsuarioDAO;


public class Autenticacao {
    
    private final UsuarioDAO usuarioDAO;
            
    public Autenticacao(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario login(LoginDTO login){
        Usuario usuario = usuarioDAO.buscarUsuarioPeloLogin(login.getLogin());
        if(usuario == null){
            return null; 
        }
        if(validarSenha(usuario.getSenha(), login.getSenha())){
            return usuario;
        }
        return null;
    }
    
    private boolean validarSenha(String senhaPreenchida, String senhaUsuario){
        return senhaPreenchida.equalsIgnoreCase(senhaUsuario);
    }
}
