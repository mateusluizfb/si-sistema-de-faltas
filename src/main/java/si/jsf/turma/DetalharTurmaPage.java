package si.jsf.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Turma;
import si.repositories.MembroRepository;
import si.repositories.TurmaRepository;
import si.util.FacesUtil;

import java.util.List;

/**
 * Created by mateus on 17/10/16.
 */

@Component
@RequestScope
public class DetalharTurmaPage {

    @Autowired
    private TurmaRepository tr;

    @Autowired
    private MembroRepository mr;

    private Turma turma;

    public List<Membro> getMembros() {
        return mr.findByTurma(getTurma().getId());
    }

    public Turma getTurma() {
        if (turma == null) {
            turma = tr.findOne(Long.valueOf(FacesUtil.getParameter("id")));
        }

        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getNoPresencas(Long membroId) {
        return mr.findNoPresencas(turma.getId(), membroId);
    }
}
