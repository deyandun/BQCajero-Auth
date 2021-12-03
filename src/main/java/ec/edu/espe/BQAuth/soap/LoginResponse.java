//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.12.02 a las 08:55:00 PM COT 
//


package ec.edu.espe.BQAuth.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="userSerializer" type="{http://espe.edu.ec/BQAuth/soap}userSerializer"/&gt;
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
    "userSerializer"
})
@XmlRootElement(name = "loginResponse")
public class LoginResponse {

    @XmlElement(required = true)
    protected UserSerializer userSerializer;

    /**
     * Obtiene el valor de la propiedad userSerializer.
     * 
     * @return
     *     possible object is
     *     {@link UserSerializer }
     *     
     */
    public UserSerializer getUserSerializer() {
        return userSerializer;
    }

    /**
     * Define el valor de la propiedad userSerializer.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSerializer }
     *     
     */
    public void setUserSerializer(UserSerializer value) {
        this.userSerializer = value;
    }

}
