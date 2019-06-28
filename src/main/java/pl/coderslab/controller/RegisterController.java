package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.User;
import pl.coderslab.repository.BusinessRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.AuthenticationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private BusinessRepository businessRepository;

    @RequestMapping("")
    public String register() {
        return "register/register";
    }

//--------------- [User] -------------------------------------------------------------------------------------------

    @GetMapping("/user")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register/registerUser";
    }

    @PostMapping("/user")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            if(user.getEmail() != null) {
                if(authenticationService.checkIfUserEmailIsInDatabase(user.getEmail())) {
                    model.addAttribute("emailError", "Na ten adres e-mail założono już konto");
                }
            }
            return "register/registerUser";
        }

        if(authenticationService.checkIfUserEmailIsInDatabase(user.getEmail())) {
            model.addAttribute("emailError", "Na ten adres e-mail założono już konto");
            return "register/registerUser";
        }

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "redirect:/authentication/login/user";
    }

//--------------- [Business] -------------------------------------------------------------------------------------------
    @GetMapping("/business")
    public String registerBusiness(Model model) {
        model.addAttribute("business", new Business());
        return "register/registerBusiness";
    }

    @PostMapping("/business")
    public String registerBusiness(@Valid Business business, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            if(business.getEmail() != null) {
                if(authenticationService.checkIfBusinessEmailIsInDatabase(business.getEmail())) {
                    model.addAttribute("emailError", "Na ten adres e-mail założono już konto");
                }
            }
            return "register/registerBusiness";
        }

        if(authenticationService.checkIfBusinessEmailIsInDatabase(business.getEmail())) {
            model.addAttribute("emailError", "Na ten adres e-mail założono już konto");
            return "register/registerBusiness";
        }

        String hashedPassword = BCrypt.hashpw(business.getPassword(), BCrypt.gensalt());
        business.setPassword(hashedPassword);
        businessRepository.save(business);
        return "redirect:/authentication/login/business";
    }

    //TODO add to registration form repeat password option

}
