package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BusinessRepository;
import pl.coderslab.repository.UserRepository;

@Service
public class AuthenticationService {

    //TODO reset your password

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BusinessRepository businessRepository;
    
    public boolean checkIfUserEmailIsInDatabase(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return true;
        } 
        return false;
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            boolean isPasswordValid = BCrypt.checkpw(password, user.getPassword());
            if (isPasswordValid) {
                return user;
            }
        }
        return null;
    }

    public boolean checkIfBusinessEmailIsInDatabase(String email) {
        Business business = businessRepository.findBusinessByEmail(email);
        if (business != null) {
            return true;
        }
        return false;
    }

    public Business authenticateBusiness(String email, String password) {
        Business business = businessRepository.findBusinessByEmail(email);
        if (business != null) {
            boolean isPasswordValid = BCrypt.checkpw(password, business.getPassword());
            if (isPasswordValid) {
                return business;
            }
        }
        return null;
    }




}
