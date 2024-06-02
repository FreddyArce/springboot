package bo.emi.dao.impl;

import bo.emi.dao.EstudianteDAO;
import bo.emi.entities.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Estudiante> obtenerEstudiantes() {
        Session session = this.sessionFactory.getCurrentSession(); // Abrir la conexion a la base de datos
        // Uso de hibernate query language
        Query<Estudiante> query = session.createQuery(
                "select e from Estudiante e where e.estado = :estado");
        query.setParameter("estado", "A"); // Filtrar los activos
        List<Estudiante> estudiantes = query.list(); // Generar el resultado de la consulta
        return estudiantes;
    }

    @Override
    public Estudiante obtenerEstudiante(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Estudiante.class, id);
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        Session session = sessionFactory.getCurrentSession();
        session.save(estudiante);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        Session session = sessionFactory.getCurrentSession();

        Estudiante estudianteUpdate = session.get(Estudiante.class, estudiante.getId());
        estudianteUpdate.setNombre(estudiante.getNombre());
        estudianteUpdate.setApellido(estudiante.getApellido());
        estudianteUpdate.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteUpdate.setSemestre(estudiante.getSemestre());
        estudianteUpdate.setCiudad(estudiante.getCiudad());
        estudianteUpdate.setDireccion(estudiante.getDireccion());
        // Actualizar los datos en la base de datos
        session.update(estudianteUpdate);
    }

    @Override
    public void eliminarEstudiante(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        Estudiante estudianteUpdate = session.get(Estudiante.class, id);
        estudianteUpdate.setEstado("E");
        // Actualizar los datos en la base de datos
        session.update(estudianteUpdate);
    }
}
