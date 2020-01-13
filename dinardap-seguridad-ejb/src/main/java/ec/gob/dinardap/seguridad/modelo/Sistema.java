package ec.gob.dinardap.seguridad.modelo;

import java.io.Serializable;
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


/**
 * The persistent class for the sistema database table.
 * 
 */
@Entity
@Table(name="sistema", schema="ec_dinardap_seguridad")
@NamedQuery(name="Sistema.findAll", query="SELECT s FROM Sistema s")
public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SISTEMA_SISTEMAID_GENERATOR", sequenceName="sistema_sistema_id_seq", schema="ec_dinardap_seguridad", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SISTEMA_SISTEMAID_GENERATOR")
	@Column(name="sistema_id")
	private Integer sistemaId;

	@Column(name="base_datos", length = 64)
	private String baseDatos;

	@Column(name="codigo_is")
	private Integer codigoIs;

	@Column(name="estado")
	private Short estado;

	@Column(name="nombre", length = 32)
	private String nombre;

	@Column(name="tipo")
	private Short tipo;

	@Column(name="url", length = 128)
	private String url;

	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="sistema")
	private List<Perfil> perfils;
	
	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="sistema")
	private List<GestionarExcel> gestionarExcels;

	public Sistema() {
	}

	public Integer getSistemaId() {
		return this.sistemaId;
	}

	public void setSistemaId(Integer sistemaId) {
		this.sistemaId = sistemaId;
	}

	public String getBaseDatos() {
		return this.baseDatos;
	}

	public void setBaseDatos(String baseDatos) {
		this.baseDatos = baseDatos;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setSistema(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setSistema(null);

		return perfil;
	}

	public List<GestionarExcel> getGestionarExcels() {
		return gestionarExcels;
	}

	public void setGestionarExcels(List<GestionarExcel> gestionarExcels) {
		this.gestionarExcels = gestionarExcels;
	}
	
	public GestionarExcel addGestionarExcel(GestionarExcel gestionarExcel) {
		getGestionarExcels().add(gestionarExcel);
		gestionarExcel.setSistema(this);

		return gestionarExcel;
	}

	public GestionarExcel removeGestionarExcel(GestionarExcel gestionarExcel) {
		getGestionarExcels().remove(gestionarExcel);
		gestionarExcel.setSistema(null);
		
		return gestionarExcel;
	}

}