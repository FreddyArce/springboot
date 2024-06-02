package bo.emi.service;

import bo.emi.dto.DocenteDTO;
import bo.emi.dto.EstudianteDTO;

import java.util.List;

public interface DocenteService {
    List<DocenteDTO> obtenerDocentes();
    DocenteDTO obtenerDocente(Integer id);
    void registrarDocente(DocenteDTO docenteDTO);
    void actualizarDocente(DocenteDTO docenteDTO);
    void eliminarDocente(Integer id);
}
