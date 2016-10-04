package si.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mateus on 03/10/16.
 */

@Entity
@Table(name = "TURMA")
public class Turma {

    private Long id;
    private String nome;
    private List<Usuario> usuarios;
    private Usuario responsavel;

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

    @ManyToMany(mappedBy = "turmas")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @JoinColumn(name = "REPONSAVEL_ID")
    @ManyToOne
    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
