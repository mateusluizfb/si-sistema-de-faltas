package si.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateus on 03/10/16.
 */

@Entity
@Table(name = "TURMA")
public class Turma {

    private Long id;
    private String nome;
    private List<Membro> membros = new ArrayList<>();
    private Membro responsavel;

    @Id
    @GeneratedValue
    @SequenceGenerator(name = "Turma.id", sequenceName = "SEQUENCE_TURMA", allocationSize = 1)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany
    @JoinTable(name = "TURMA_HAS_MEMBROS", joinColumns = {@JoinColumn(name = "TURMA_ID")}, inverseJoinColumns = {@JoinColumn(name = "MEMBRO_ID")})
    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    @JoinColumn(name = "REPONSAVEL_ID")
    @ManyToOne
    public Membro getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Membro responsavel) {
        this.responsavel = responsavel;
    }
}
