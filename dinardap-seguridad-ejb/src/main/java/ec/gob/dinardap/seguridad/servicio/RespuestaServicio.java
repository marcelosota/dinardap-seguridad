package ec.gob.dinardap.seguridad.servicio;

import javax.ejb.Local;

import ec.gob.dinardap.persistence.servicio.GenericService;
import ec.gob.dinardap.seguridad.modelo.Respuesta;
import java.util.List;

@Local
public interface RespuestaServicio extends GenericService<Respuesta, Integer> {
    public List<Respuesta> getRespuestasActivas(Integer usuarioId);
    public Respuesta getRespuestaByUsuario(Integer idUsuario, Integer idPregunta);
}
