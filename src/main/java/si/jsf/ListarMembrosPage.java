package si.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Turma;
import si.enums.TipoPerfil;
import si.repositories.CustomMembroRepository;
import si.repositories.MembroRepository;
import si.repositories.TurmaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateus on 10/10/16.
 */
@Component
@RequestScope
public class ListarMembrosPage {

    @Autowired
    private MembroRepository mr;

    @Autowired
    private TurmaRepository tr;

    @Autowired
    private CustomMembroRepository cmr;

    public List<Membro> getMembros(){
        return mr.findAll();
    }

    public String delete(Long membroID){

//        mr.delete(membroID);
        if(mr.findOne(membroID).getTipoPerfil().equals(TipoPerfil.AL)){
            cmr.deleteAll(membroID);
            cmr.delete(membroID);
        } else {
            cmr.deleteReso(membroID);
            cmr.delete(membroID);
        }

        return null;
    }

}
