package si.jsf;

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
}
