package si.jsf.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.repositories.MembroRepository;
import si.repositories.TurmaRepository;
import si.util.FacesUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by mateus on 20/10/16.
 */

@Component
@RequestScope
public class RegistrarPresencaPage {

    @Autowired
    private MembroRepository mr;

    @Autowired
    private TurmaRepository tr;

    private Long[] membros;
    private Date dataRegistro;

    public List<Membro> findAlunos(Long id){
        return mr.findByTurmasId(id);
    }

    public String getTurmaId(){
        return FacesUtil.getParameter("id");
    }

    public List<Membro> getAlunos(){
        return mr.findByTurmasId(Long.valueOf(getTurmaId()));
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Long[] getMembros() {
        return membros;
    }

    public void setMembros(Long[] membros) {
        this.membros = membros;
    }
}
