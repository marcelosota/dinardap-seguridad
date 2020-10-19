package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the perfil database table.
 *
 */
@Entity
@Table(name = "perfil", schema = "ec_dinardap_seguridad")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PERFIL_PERFILID_GENERATOR", sequenceName = "perfil_perfil_id_seq", schema = "ec_dinardap_seguridad", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERFIL_PERFILID_GENERATOR")
    @Column(name = "perfil_id")
    private Integer perfilId;

    @Column(name = "codigo_is")
    private Integer codigoIs;

    @Column(name = "estado")
    private Short estado;

    @Column(name = "nombre", length = 32)
    private String nombre;

    @Column(name = "tipo")
    private Short tipo;

    //bi-directional many-to-one association to Sistema
    @ManyToOne
    @JoinColumn(name = "sistema_id")
    private Sistema sistema;

    //bi-directional many-to-one association to Permiso
    @OneToMany(mappedBy = "perfil")
    private List<Permiso> permisos;

    public Perfil() {
    }

    public Integer getPerfilId() {
        return this.perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public Integer getCodigoIs() {
        return this.codigoIs;
    }

    public void setCodigoIs(Integer codigoIs) {
        this.codigoIs = codigoIs;
    }

    public Short getEstado() {
        return this.estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getTipo() {
        return this.tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public Sistema getSistema() {
        return this.sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Permiso> getPermisos() {
        return this.permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Permiso addPermiso(Permiso permiso) {
        getPermisos().add(permiso);
        permiso.setPerfil(this);

        return permiso;
    }

    public Permiso removePermiso(Permiso permiso) {
        getPermisos().remove(permiso);
        permiso.setPerfil(null);

        return permiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilId != null ? perfilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilId == null && other.perfilId != null) || (this.perfilId != null && !this.perfilId.equals(other.perfilId))) {
            return false;
        }
        return true;
    }

}
