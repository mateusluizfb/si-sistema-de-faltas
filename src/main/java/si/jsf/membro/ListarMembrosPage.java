package si.jsf.membro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.repositories.MembroRepository;

import java.util.List;

/**
 * Created by mateus on 10/10/16.
 */
@Component
@RequestScope
public class ListarMembrosPage {

    @Autowired
    private MembroRepository mr;

    public List<Membro> getMembros(){
        return mr.findAll();
    }

    public String delete(Long membroID){

        Membro membro = mr.findOne(membroID);

        membro.getTurmas().clear();
        membro.getPresencas().clear();

        mr.save(membro);
        mr.delete(membroID);

        return null;
    }

}
