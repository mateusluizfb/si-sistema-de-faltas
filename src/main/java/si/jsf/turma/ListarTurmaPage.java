package si.jsf.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Turma;
import si.repositories.TurmaRepository;

import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Component
@RequestScope
public class ListarTurmaPage {

    @Autowired
    private TurmaRepository tr;

    public List<Turma> getTurmas(){
        return tr.findAll();
    }

    public void delete(Long id){
        Turma turma = tr.findOne(id);

        turma.getMembros().clear();

        tr.save(turma);

        tr.removePresencas(id);
        tr.deleteTurma(id);
    }
}
