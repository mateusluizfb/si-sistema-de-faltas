package si.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Turma;
import si.enums.TipoPerfil;
import si.repositories.MembroRepository;

import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Component
@RequestScope
public class IncluirTurmaPage {

    @Autowired
    private MembroRepository mr;

    private Turma turma;

    public List<Membro> getResponsaveis(){
        return mr.findAllByTipoPerfilIn(TipoPerfil.PF);
    }

    public Turma getTurma() {
        if(turma == null){
            turma = new Turma();
        }
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
