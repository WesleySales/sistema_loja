package entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String login;
    private String senha;
    private UsuarioCargoEnum cargo;

    public Usuario(String nome, String sobrenome, String login, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
    }
    
   
    
    public Usuario(){
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UsuarioCargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(UsuarioCargoEnum cargo) {
        this.cargo = cargo;
    }
      
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }
    
    
    
    
}
