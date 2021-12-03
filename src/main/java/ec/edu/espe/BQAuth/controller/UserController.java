package ec.edu.espe.BQAuth.controller;


import ec.edu.espe.BQAuth.soap.*;
import ec.edu.espe.BQAuth.model.Users;
import ec.edu.espe.BQAuth.service.AuthenticationService;
import ec.edu.espe.BQAuth.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDateTime;

@Endpoint
@CrossOrigin
@RequestMapping("/api/v1/user")
@Data
@Slf4j
public class UserController {

    private static final String NAMESPACE_URI = "http://BQAuth.espe.edu.ec/soap";

    @Autowired
    private AuthenticationService authenticationService;
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) throws Exception {
        LoginResponse response = new LoginResponse();
        LoginSerializer loginSerializer = request.getUsername();
        try {
            Users user = authenticationService.login(
                    loginSerializer.getUsername(),
                    loginSerializer.getEncodedPassword());
            response.setUserSerializer(UserSerializer.serializeOne(user));
            return response;
        } catch (IllegalArgumentException exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createRequest")
    @ResponsePayload
    public CreateResponse create(@RequestPayload CreateRequest request) throws Exception {
        CreateResponse response = new CreateResponse();
        LocalDateTime dateTime = LocalDateTime.now();
        UserCreationSerializer userSerializer = request.getUserCreation();
        try {
            log.info("creating user: ", userSerializer);
            Users user = new Users();
            user.setIdentifier(userSerializer.getIdentifier());
            user.setType(userSerializer.getType());
            user.setUsername(userSerializer.getUsername().toLowerCase());
            user.setName(userSerializer.getName().toUpperCase());
            user.setPassword(userSerializer.getPassword());
            user.setCreatedAt(java.sql.Timestamp.valueOf(dateTime));
            Users newUser = userService.create(user);
            ec.edu.espe.BQAuth.soap.Users users = new ec.edu.espe.BQAuth.soap.Users();
            users.setIdentifier(newUser.getIdentifier());
            users.setType(newUser.getType());
            users.setUsername(newUser.getUsername());
            users.setName(newUser.getName());
            users.setPassword(newUser.getPassword());
            users.setCreatedAt(DatatypeFactory.newInstance().newXMLGregorianCalendar(newUser.getCreatedAt().toString()));
            response.setUser(users);
            return response;
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeRequest")
    @ResponsePayload
    public RemoveResponse remove(@RequestPayload RemoveRequest request) throws Exception {
        RemoveResponse response = new RemoveResponse();
        try {
            userService.delete(request.getId());
            response.setStatus("Ok");
            return response;
        } catch (IllegalArgumentException exception) {
            throw new Exception(exception.getMessage());
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }




}
