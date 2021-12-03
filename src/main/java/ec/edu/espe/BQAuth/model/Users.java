package ec.edu.espe.BQAuth.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.DatatypeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.core.codec.EncodingException;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users implements Serializable {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    
    @Basic(optional = false)
    @Column(name = "identifier", nullable = false)
    private String identifier;
    
    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;
    
    @Basic(optional = false)
    @Column(name = "type", nullable = false)
    private String type;
    
    @Basic(optional = false)
    @Column(name = "username", nullable = false)
    private String username;
    
    @Basic(optional = false)
    @Column(name = "password", nullable = false)
    private String password;
        
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

  
    
    public void setEncodedPassword() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            password = DatatypeConverter
                    .printHexBinary(
                            messageDigest.digest(password.getBytes("UTF-8")));
        } catch (Exception exception) {
            throw new EncodingException("Password could not be encoded.");
        }
    }
}
