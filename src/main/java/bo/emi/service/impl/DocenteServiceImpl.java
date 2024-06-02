package bo.emi.service.impl;

import bo.emi.dao.DocenteDAO;
import bo.emi.dto.DocenteDTO;
import bo.emi.dto.EstudianteDTO;
import bo.emi.entities.Ciudad;
import bo.emi.entities.Docente;
import bo.emi.entities.Estudiante;
import bo.emi.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {
    @Autowired
    private DocenteDAO docenteDAO;

    @Override
    @Transactional
    public List<DocenteDTO> obtenerDocentes() {
        List<Docente> docentes = docenteDAO.obtenerDocentes();
        List<DocenteDTO> docenteDTOS = new ArrayList<>();

        // Copiar las entidades a los DTOS
        for (Docente docente : docentes) {
            Ciudad ciudad = docente.getCiudad();
            docenteDTOS.add(new DocenteDTO(docente.getId(), docente.getNombre(),
                    docente.getApellido(), docente.getFechaNacimiento(), docente.getAntiguedad(),
                    ciudad.getId(), ciudad.getNombre(), docente.getDireccion()
            ));
        }
        return docenteDTOS;
    }

    @Override
    public DocenteDTO obtenerDocente(Integer id) {
        return null;
    }

    @Override
    public void registrarDocente(DocenteDTO docenteDTO) {

    }

    @Override
    public void actualizarDocente(DocenteDTO docenteDTO) {

    }

    @Override
    public void eliminarDocente(Integer id) {

    }
}
