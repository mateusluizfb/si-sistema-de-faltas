package si.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import si.entities.Membro;
import si.entities.Turma;
import si.enums.TipoPerfil;
import si.repositories.MembroRepository;
import si.repositories.TurmaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mateus on 05/10/16.
 */

@Component
@RequestScope
public class IncluirTurmaPage {

    @Autowired
    private MembroRepository mr;

    @Autowired
    private TurmaRepository tr;

    private Turma turma;
    private Long idResponsavel;
    private Long[] membros;

    public List<Membro> getResponsaveis(){
        return mr.findAllByTipoPerfilIn(TipoPerfil.PF);
    }

    public List<Membro> getAlunos(){
        return mr.findAllByTipoPerfilIn(TipoPerfil.AL);
    }

    public Turma getTurma() {
        if(turma == null){
            turma = new Turma();
        }
        return turma;
    }

    public String save(){
        List<Membro> list = new ArrayList<>();
        saveAlunos(list);
        turma.setMembros(list);
        turma.setResponsavel(mr.findOne(idResponsavel));
        tr.save(turma);
        return "listagem_turmas";
    }

    private void saveAlunos(List list){
        for (Long mID: membros) {
            list.add(mr.findOne(mID));
        }
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Long[] getMembros() {
        return membros;
    }

    public void setMembros(Long[] membros) {
        this.membros = membros;
    }
}
