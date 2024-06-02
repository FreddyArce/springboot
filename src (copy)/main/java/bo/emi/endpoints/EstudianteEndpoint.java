package bo.emi.endpoints;

import bo.emi.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EstudianteEndpoint {
    private static final String NAMESPACE_URI = "http://emi.bo/estudiantes";
    @Autowired
    private EstudianteService estudianteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "estudianteRequest")
    @ResponsePayload
    public EstudianteResponse obtenerEstudiantes(EstudianteRequest request) {
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteResponse.setEstudiantes(estudianteService.obtenerEstudiantes());
        return estudianteResponse;
    }
}
