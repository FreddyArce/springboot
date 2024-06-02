package bo.emi.endpoints;

import bo.emi.dto.EstudianteDTO;
import bo.emi.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import bo.emi.envelopes.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
public class EstudianteEndpoint {
    private static final String NAMESPACE_URI = "http://emi.bo/app";
    @Autowired
    private EstudianteService estudianteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "estudiantesRequest")
    @ResponsePayload
    public EstudiantesResponse obtenerEstudiantes(@RequestPayload EstudiantesRequest request) throws DatatypeConfigurationException {
        EstudiantesResponse estudianteResponse = new EstudiantesResponse();

        List<EstudianteDTO> estudianteDTOS = estudianteService.obtenerEstudiantes();

        for (EstudianteDTO estudianteDTO : estudianteDTOS) {
            EstudiantePayload payload = new EstudiantePayload();
            payload.setNombre(estudianteDTO.getNombre());
            payload.setApellido(estudianteDTO.getApellido());
            payload.setCiudad(estudianteDTO.getCiudad());
            payload.setId(estudianteDTO.getId());
            payload.setSemestre(estudianteDTO.getSemestre());
            payload.setIdCiudad(estudianteDTO.getIdCiudad());

            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(estudianteDTO.getFechaNacimiento());

            payload.setFechaNacimiento(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
            payload.setDireccion(estudianteDTO.getDireccion());
            estudianteResponse.getEstudiantes().add(payload);
        }

        return estudianteResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "estudiantePayload")
    @ResponsePayload
    public EstudiantesConfirmation registrarEstudiante(@RequestPayload EstudiantePayload estudiantePayload) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre(estudiantePayload.getNombre());
        estudianteDTO.setApellido(estudiantePayload.getApellido());
        estudianteDTO.setCiudad(estudiantePayload.getCiudad());
        estudianteDTO.setDireccion(estudiantePayload.getDireccion());
        estudianteDTO.setId(estudiantePayload.getId());
        estudianteDTO.setIdCiudad(estudiantePayload.getIdCiudad());
        estudianteDTO.setSemestre(estudiantePayload.getSemestre());

        GregorianCalendar gc = estudiantePayload.getFechaNacimiento().toGregorianCalendar();

        estudianteDTO.setFechaNacimiento(gc.getTime());
        estudianteService.registrarEstudiante(estudianteDTO);
        EstudiantesConfirmation confirmation = new EstudiantesConfirmation();
        confirmation.setResultado("ok");
        return confirmation;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "estudianteUpdate")
    @ResponsePayload
    public EstudiantesConfirmation actualizarEstudiante(@RequestPayload EstudianteUpdate estudianteUpdate) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setId(estudianteUpdate.getId());
        estudianteDTO.setNombre(estudianteUpdate.getNombre());
        estudianteDTO.setApellido(estudianteUpdate.getApellido());
        estudianteDTO.setCiudad(estudianteUpdate.getCiudad());
        estudianteDTO.setDireccion(estudianteUpdate.getDireccion());
        estudianteDTO.setId(estudianteUpdate.getId());
        estudianteDTO.setIdCiudad(estudianteUpdate.getIdCiudad());
        estudianteDTO.setSemestre(estudianteUpdate.getSemestre());

        GregorianCalendar gc = estudianteUpdate.getFechaNacimiento().toGregorianCalendar();

        estudianteDTO.setFechaNacimiento(gc.getTime());
        estudianteService.actualizarEstudiante(estudianteDTO);
        EstudiantesConfirmation confirmation = new EstudiantesConfirmation();
        confirmation.setResultado("ok");
        return confirmation;
    }
}
