package si.entities;

import si.enums.TipoPerfil;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mateus on 29/09/16.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {

    private Long id;
    private String nome;
    private TipoPerfil tipoPerfil;
    private List<Presenca> presencas;
    private List<Turma> turmas;

    @Id
    @GeneratedValue(generator = "Usuario.id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Usuario.id", sequenceName = "USUARIO_SEQUENCE", allocationSize = 1)
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

    @Column(name = "TIPO_PERFIL")
    @Enumerated(EnumType.STRING)
    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    @OneToMany(mappedBy = "usuario")
    public List<Presenca> getPresencas() {
        return presencas;
    }

    public void setPresencas(List<Presenca> presencas) {
        this.presencas = presencas;
    }

    @ManyToMany
    @JoinTable(name = "USUARIO_HAS_TURMAS", joinColumns = {@JoinColumn(name = "USUARIO_ID")}, inverseJoinColumns = {@JoinColumn(name = "TURMA_ID")})
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
