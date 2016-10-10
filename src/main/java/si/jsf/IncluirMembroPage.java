package si.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.enums.TipoPerfil;
import si.repositories.MembroRepository;

/**
 * Created by mateus on 10/10/16.
 */

@Component
@RequestScope
public class IncluirMembroPage {

    @Autowired
    private MembroRepository mr;

    private Membro membro;

    public TipoPerfil[] getPerfis(){
        return TipoPerfil.values();
    }

    public String save(){
        mr.save(membro);
        return "listagem_membros";
    }

    public Membro getMembro() {
        if(membro == null){
            membro = new Membro();
        }
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
}
