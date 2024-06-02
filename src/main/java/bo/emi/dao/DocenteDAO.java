package bo.emi.dao;

import bo.emi.entities.Docente;
import bo.emi.entities.Estudiante;

import java.util.List;

public interface DocenteDAO {
    List<Docente> obtenerDocentes();

    Estudiante obtenerDocente(Integer id);
    void registrarDocente(Estudiante estudiante);
    void actualizarDocente(Estudiante estudiante);
    void eliminarDocente(Integer id);
}
