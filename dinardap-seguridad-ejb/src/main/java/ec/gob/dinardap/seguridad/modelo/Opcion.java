package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@Table(name="opcion", schema="ec_dinardap_seguridad")
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPCION_OPCIONID_GENERATOR", sequenceName="opcion_opcion_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPCION_OPCIONID_GENERATOR")
	@Column(name="opcion_id")
	private Integer opcionId;

	@Column(name="estado")
	private Short estado;

	@Column(name="nivel")
	private Short nivel;

	@Column(name="nombre", length = 32)
	private String nombre;

	@Column(name="orden")
	private Short orden;

	@Column(name="url", length = 128)
	private String url;

	@Column(name="visible")
	private Boolean visible;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="padre_id")
	private Opcion opcion;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="opcion",fetch=FetchType.EAGER)
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="opcion")
	private List<Permiso> permisos;

	public Opcion() {
	}

	public Integer getOpcionId() {
		return this.opcionId;
	}

	public void setOpcionId(Integer opcionId) {
		this.opcionId = opcionId;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Short getNivel() {
		return this.nivel;
	}

	public void setNivel(Short nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Short getOrden() {
		return this.orden;
	}

	public void setOrden(Short orden) {
		this.orden = orden;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setOpcion(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setOpcion(null);

		return opcion;
	}

	public List<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Permiso addPermiso(Permiso permiso) {
		getPermisos().add(permiso);
		permiso.setOpcion(this);

		return permiso;
	}

	public Permiso removePermiso(Permiso permiso) {
		getPermisos().remove(permiso);
		permiso.setOpcion(null);

		return permiso;
	}

	@Override
	public String toString() {
		return "Opcion [opcionId=" + opcionId + ", estado=" + estado + ", nivel=" + nivel + ", nombre=" + nombre
				+ ", orden=" + orden + ", url=" + url + ", visible=" + visible + ", opcion=" + opcion + ", opcions="
				+ opcions + ", permisos=" + permisos + "]";
	}

}