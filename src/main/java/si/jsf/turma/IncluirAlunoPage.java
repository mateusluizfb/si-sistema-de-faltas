package si.jsf.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Turma;
import si.enums.TipoPerfil;
import si.repositories.MembroRepository;
import si.util.FacesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateus on 07/11/16.
 */

@Component
@RequestScope
public class IncluirAlunoPage {

    @Autowired
    private MembroRepository mr;

    public List<Membro> getAlunos(){
        List<Membro> membros = mr.findAllByTipoPerfilIn(TipoPerfil.AL);
        Long id = Long.valueOf(FacesUtil.getParameter("id"));

        return membros;
    }
}
