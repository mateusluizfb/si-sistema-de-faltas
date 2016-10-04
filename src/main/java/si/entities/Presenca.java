package si.entities;

import si.enums.TipoPresenca;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mateus on 29/09/16.
 */

@Entity
@Table(name = "PRESENCA")
public class Presenca {

    private Long id;
    private Date dataCadastro;
    private TipoPresenca tipoPresenca;
    private Usuario usuario;

    @Id
    @GeneratedValue(generator = "Presenca.id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Presenca.id", sequenceName = "PRESENCA_SEQUENCE", allocationSize = 1)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name = "TIPO_PRESENCA")
    @Enumerated(EnumType.STRING)
    public TipoPresenca getTipoPresenca() {
        return tipoPresenca;
    }

    public void setTipoPresenca(TipoPresenca tipoPresenca) {
        this.tipoPresenca = tipoPresenca;
    }

    @JoinColumn(name = "USUARIO_ID")
    @ManyToOne
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
