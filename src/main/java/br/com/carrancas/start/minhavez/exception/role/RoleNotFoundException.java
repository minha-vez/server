package br.com.carrancas.start.minhavez.exception.role;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(String enumRole) {
        super("Role " + enumRole + "não encontrada! ");
    }
}
