package si.enums;

/**
 * Created by mateus on 03/10/16.
 */
public enum TipoPerfil {

    AL("Aluno"), PF("Professor");

    public String tipoPerfil;

    TipoPerfil(String tipoPerfil){
        this.tipoPerfil = tipoPerfil;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }
}
