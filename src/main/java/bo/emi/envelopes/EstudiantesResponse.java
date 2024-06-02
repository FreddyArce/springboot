//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.1 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.06.02 a las 05:46:09 PM BOT 
//


package bo.emi.envelopes;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="estudiantes" type="{http://emi.bo/app}estudiantePayload" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "estudiantes"
})
@XmlRootElement(name = "estudiantesResponse")
public class EstudiantesResponse {

    @XmlElement(required = true)
    protected List<EstudiantePayload> estudiantes;

    /**
     * Gets the value of the estudiantes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the estudiantes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstudiantes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstudiantePayload }
     * 
     * 
     */
    public List<EstudiantePayload> getEstudiantes() {
        if (estudiantes == null) {
            estudiantes = new ArrayList<EstudiantePayload>();
        }
        return this.estudiantes;
    }

}
