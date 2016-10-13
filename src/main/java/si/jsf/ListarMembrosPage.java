package si.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.repositories.CustomMembroRepository;
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

    @Autowired
    private CustomMembroRepository cmr;

    public List<Membro> getMembros(){
        return mr.findAll();
    }

    public String delete(Long id){
        cmr.deleteAll(id);
        cmr.delete(id);
        return null;
    }

}
