//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.12.02 a las 08:55:00 PM COT 
//


package ec.edu.espe.BQAuth.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.espe.bqauth.soap package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.espe.bqauth.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginRequest }
     * 
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    /**
     * Create an instance of {@link LoginSerializer }
     * 
     */
    public LoginSerializer createLoginSerializer() {
        return new LoginSerializer();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link UserSerializer }
     * 
     */
    public UserSerializer createUserSerializer() {
        return new UserSerializer();
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

    /**
     * Create an instance of {@link UserCreationSerializer }
     * 
     */
    public UserCreationSerializer createUserCreationSerializer() {
        return new UserCreationSerializer();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUser() {
        return new Users();
    }

    /**
     * Create an instance of {@link RemoveRequest }
     * 
     */
    public ec.edu.espe.BQAuth.soap.RemoveRequest createRemoveRequest() {
        return new ec.edu.espe.BQAuth.soap.RemoveRequest();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public ec.edu.espe.BQAuth.soap.RemoveResponse createRemoveResponse() {
        return new ec.edu.espe.BQAuth.soap.RemoveResponse();
    }

}
