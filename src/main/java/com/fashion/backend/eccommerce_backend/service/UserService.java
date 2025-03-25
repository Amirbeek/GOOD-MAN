package com.fashion.backend.eccommerce_backend.service;

import com.fashion.backend.eccommerce_backend.api.model.RegistrationBody;
import com.fashion.backend.eccommerce_backend.exception.UserAlreadyExistException;
import com.fashion.backend.eccommerce_backend.model.LocalUser;
import com.fashion.backend.eccommerce_backend.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser( RegistrationBody registrationBody) throws UserAlreadyExistException {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        LocalUser user = new LocalUser();
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());
        // TODO Encrypt password!
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);
    }
}
