
package entities;

public enum UsuarioCargoEnum {
    GERENTE(1),
    VENDEDOR(2);

    int numero;

    private UsuarioCargoEnum(int numero) {
        this.numero = numero;
    }
    
    
}

