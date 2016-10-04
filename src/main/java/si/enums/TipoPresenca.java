package si.enums;

/**
 * Created by mateus on 03/10/16.
 */
public enum TipoPresenca {

    PR("Presente"), FL("Falta"), AT("Atraso");

    private String tipoPresenca;

    TipoPresenca(String tipoPresenca){
        this.tipoPresenca = tipoPresenca;
    }
}
