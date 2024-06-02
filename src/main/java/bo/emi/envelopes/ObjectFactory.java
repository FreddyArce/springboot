//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.1 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.06.02 a las 05:46:09 PM BOT 
//


package bo.emi.envelopes;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bo.emi.envelopes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bo.emi.envelopes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EstudiantesRequest }
     * 
     */
    public EstudiantesRequest createEstudiantesRequest() {
        return new EstudiantesRequest();
    }

    /**
     * Create an instance of {@link EstudiantesResponse }
     * 
     */
    public EstudiantesResponse createEstudiantesResponse() {
        return new EstudiantesResponse();
    }

    /**
     * Create an instance of {@link EstudiantePayload }
     * 
     */
    public EstudiantePayload createEstudiantePayload() {
        return new EstudiantePayload();
    }

    /**
     * Create an instance of {@link EstudiantesConfirmation }
     * 
     */
    public EstudiantesConfirmation createEstudiantesConfirmation() {
        return new EstudiantesConfirmation();
    }

    /**
     * Create an instance of {@link EstudianteUpdate }
     * 
     */
    public EstudianteUpdate createEstudianteUpdate() {
        return new EstudianteUpdate();
    }

}
