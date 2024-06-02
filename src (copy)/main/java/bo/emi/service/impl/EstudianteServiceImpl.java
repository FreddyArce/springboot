package bo.emi.service.impl;

import bo.emi.dao.CiudadDAO;
import bo.emi.dao.EstudianteDAO;
import bo.emi.dto.EstudianteDTO;
import bo.emi.entities.Ciudad;
import bo.emi.entities.Estudiante;
import bo.emi.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService {
    // Inyectar el objeto de acceso a datos.
    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private CiudadDAO ciudadDAO;
    @Override
    @Transactional
    public List<EstudianteDTO> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        List<EstudianteDTO> estudianteDTOS = new ArrayList<>();

        // Copiar las entidades a los DTOS
        for (Estudiante estudiante : estudiantes) {
            Ciudad ciudad = estudiante.getCiudad();
            estudianteDTOS.add(new EstudianteDTO(estudiante.getId(), estudiante.getNombre(),
                    estudiante.getApellido(), estudiante.getFechaNacimiento(), estudiante.getSemestre(),
                    ciudad.getId(), ciudad.getNombre(), estudiante.getDireccion()
            ));
        }
        return estudianteDTOS;
    }

    @Override
    @Transactional
    public EstudianteDTO obtenerEstudiante(Integer id) {
        // Ejercicio: Completar
        Estudiante estudiante = estudianteDAO.obtenerEstudiante(id);
        EstudianteDTO estudianteDTO = null;

        if (estudiante != null) {
            Ciudad ciudad = estudiante.getCiudad();
            estudianteDTO = new EstudianteDTO(estudiante.getId(), estudiante.getNombre(),
                    estudiante.getApellido(), estudiante.getFechaNacimiento(), estudiante.getSemestre(),
                    ciudad.getId(), ciudad.getNombre(), estudiante.getDireccion()
            );
        }

        return estudianteDTO;
    }

    @Override
    @Transactional
    public void registrarEstudiante(EstudianteDTO estudianteDTO) {
        Ciudad ciudad = ciudadDAO.obtenerCiudad(estudianteDTO.getIdCiudad());
        Estudiante estudiante = new Estudiante(null, estudianteDTO.getNombre(), estudianteDTO.getApellido(),
                estudianteDTO.getFechaNacimiento(), estudianteDTO.getSemestre(), ciudad,
                estudianteDTO.getDireccion(), "A");
        estudianteDAO.registrarEstudiante(estudiante);
    }

    @Override
    @Transactional
    public void actualizarEstudiante(EstudianteDTO estudianteDTO) {
        Ciudad ciudad = ciudadDAO.obtenerCiudad(estudianteDTO.getIdCiudad());
        Estudiante estudiante = new Estudiante(estudianteDTO.getId(), estudianteDTO.getNombre(),
                estudianteDTO.getApellido(), estudianteDTO.getFechaNacimiento(),
                estudianteDTO.getSemestre(), ciudad,
                estudianteDTO.getDireccion(), "A");
        estudianteDAO.actualizarEstudiante(estudiante);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Integer id) {
        estudianteDAO.eliminarEstudiante(id);
    }
}
