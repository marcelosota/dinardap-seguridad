package ec.gob.dinardap.seguridad.dto;

public class ValidacionDto {

	public Integer usuarioId;
	public Integer institucionId;
	public String perfil;
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(Integer institucionId) {
		this.institucionId = institucionId;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
