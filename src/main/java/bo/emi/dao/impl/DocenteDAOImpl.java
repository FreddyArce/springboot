package bo.emi.dao.impl;

import bo.emi.dao.DocenteDAO;
import bo.emi.entities.Docente;
import bo.emi.entities.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class DocenteDAOImpl implements DocenteDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Docente> obtenerDocentes() {
        Session session = this.sessionFactory.getCurrentSession(); // Abrir la conexion a la base de datos
        // Uso de hibernate query language
        Query<Docente> query = session.createQuery(
                "select e from Docente e where e.estado = :estado");
        query.setParameter("estado", "A"); // Filtrar los activos
        List<Docente> docentes = query.list(); // Generar el resultado de la consulta
        return docentes;
    }

    @Override
    public Estudiante obtenerDocente(Integer id) {
        return null;
    }

    @Override
    public void registrarDocente(Estudiante estudiante) {

    }

    @Override
    public void actualizarDocente(Estudiante estudiante) {

    }

    @Override
    public void eliminarDocente(Integer id) {

    }
}
