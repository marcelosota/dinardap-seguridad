package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the paquete database table.
 * 
 */
@Entity
@Table(name="paquete", schema="ec_dinardap_seguridad")
@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p")
public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAQUETE_PAQUETEID_GENERATOR", sequenceName="paquete_paquete_id_seq", schema="ec_dinardap_seguridad")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAQUETE_PAQUETEID_GENERATOR")
	@Column(name="paquete_id")
	private Integer paqueteId;

	@Column(name="codigo", length = 16)
	private String codigo;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to Asignacion
	@OneToMany(mappedBy="paquete")
	private List<Asignacion> asignacions;

	//bi-directional many-to-one association to CampoPaquete
	@OneToMany(mappedBy="paquete")
	private List<CampoPaquete> campoPaquetes;

	public Paquete() {
	}

	public Integer getPaqueteId() {
		return this.paqueteId;
	}

	public void setPaqueteId(Integer paqueteId) {
		this.paqueteId = paqueteId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Asignacion> getAsignacions() {
		return this.asignacions;
	}

	public void setAsignacions(List<Asignacion> asignacions) {
		this.asignacions = asignacions;
	}

	public Asignacion addAsignacion(Asignacion asignacion) {
		getAsignacions().add(asignacion);
		asignacion.setPaquete(this);

		return asignacion;
	}

	public Asignacion removeAsignacion(Asignacion asignacion) {
		getAsignacions().remove(asignacion);
		asignacion.setPaquete(null);

		return asignacion;
	}

	public List<CampoPaquete> getCampoPaquetes() {
		return this.campoPaquetes;
	}

	public void setCampoPaquetes(List<CampoPaquete> campoPaquetes) {
		this.campoPaquetes = campoPaquetes;
	}

	public CampoPaquete addCampoPaquete(CampoPaquete campoPaquete) {
		getCampoPaquetes().add(campoPaquete);
		campoPaquete.setPaquete(this);

		return campoPaquete;
	}

	public CampoPaquete removeCampoPaquete(CampoPaquete campoPaquete) {
		getCampoPaquetes().remove(campoPaquete);
		campoPaquete.setPaquete(null);

		return campoPaquete;
	}

}