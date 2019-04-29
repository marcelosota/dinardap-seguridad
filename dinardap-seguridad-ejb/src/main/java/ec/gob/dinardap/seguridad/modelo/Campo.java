package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the campo database table.
 * 
 */
@Entity
@Table(name="campo", schema="ec_dinardap_seguridad")
@NamedQuery(name="Campo.findAll", query="SELECT c FROM Campo c")
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMPO_CAMPOID_GENERATOR", sequenceName="campo_campo_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMPO_CAMPOID_GENERATOR")
	@Column(name="campo_id")
	private Integer campoId;

	@Column(name="codigo", length = 16)
	private String codigo;

	@Column(name="descripcion", length = 256)
	private String descripcion;

	@Column(name="estado")
	private Short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="nombre", length = 64)
	private String nombre;

	//bi-directional many-to-one association to Fuente
	@ManyToOne
	@JoinColumn(name="fuente_id")
	private Fuente fuente;

	//bi-directional many-to-one association to CampoPaquete
	@OneToMany(mappedBy="campo")
	private List<CampoPaquete> campoPaquetes;

	public Campo() {
	}

	public Integer getCampoId() {
		return this.campoId;
	}

	public void setCampoId(Integer campoId) {
		this.campoId = campoId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fuente getFuente() {
		return this.fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	public List<CampoPaquete> getCampoPaquetes() {
		return this.campoPaquetes;
	}

	public void setCampoPaquetes(List<CampoPaquete> campoPaquetes) {
		this.campoPaquetes = campoPaquetes;
	}

	public CampoPaquete addCampoPaquete(CampoPaquete campoPaquete) {
		getCampoPaquetes().add(campoPaquete);
		campoPaquete.setCampo(this);

		return campoPaquete;
	}

	public CampoPaquete removeCampoPaquete(CampoPaquete campoPaquete) {
		getCampoPaquetes().remove(campoPaquete);
		campoPaquete.setCampo(null);

		return campoPaquete;
	}

}