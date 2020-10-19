package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipo_institucion database table.
 *
 */
@Entity
@Table(name = "tipo_institucion", schema = "ec_dinardap_seguridad")
@NamedQuery(name = "TipoInstitucion.findAll", query = "SELECT t FROM TipoInstitucion t")
public class TipoInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TIPO_INSTITUCION_TIPOINSTITUCIONID_GENERATOR", sequenceName = "tipo_institucion_tipo_institucion_id_seq", schema = "ec_dinardap_seguridad", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_INSTITUCION_TIPOINSTITUCIONID_GENERATOR")
    @Column(name = "tipo_institucion_id")
    private Integer tipoInstitucionId;

    private String descripcion;

    private Short estado;

    //bi-directional many-to-one association to Institucion
    @OneToMany(mappedBy = "tipoInstitucion")
    private List<Institucion> institucions;

    public TipoInstitucion() {
    }

    public Integer getTipoInstitucionId() {
        return this.tipoInstitucionId;
    }

    public void setTipoInstitucionId(Integer tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getEstado() {
        return this.estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public List<Institucion> getInstitucions() {
        return this.institucions;
    }

    public void setInstitucions(List<Institucion> institucions) {
        this.institucions = institucions;
    }

    public Institucion addInstitucion(Institucion institucion) {
        getInstitucions().add(institucion);
        institucion.setTipoInstitucion(this);

        return institucion;
    }

    public Institucion removeInstitucion(Institucion institucion) {
        getInstitucions().remove(institucion);
        institucion.setTipoInstitucion(null);

        return institucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoInstitucionId != null ? tipoInstitucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoInstitucion)) {
            return false;
        }
        TipoInstitucion other = (TipoInstitucion) object;
        if ((this.tipoInstitucionId == null && other.tipoInstitucionId != null) || (this.tipoInstitucionId != null && !this.tipoInstitucionId.equals(other.tipoInstitucionId))) {
            return false;
        }
        return true;
    }

}
