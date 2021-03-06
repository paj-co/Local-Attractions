package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.User;
import pl.coderslab.model.BusinessLogin;
import pl.coderslab.model.UserLogin;
import pl.coderslab.service.AuthenticationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/authentication")
@SessionAttributes({"loggedUser", "loggedBusiness"})
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


//--------------- [User] -------------------------------------------------------------------------------------------
    @GetMapping("/login/user")
    public String loginUser(Model model, HttpSession sess) {
        if(((Business)sess.getAttribute("loggedBusiness")) != null) {
            return "redirect:/businessapp/dashboard/";
        }
        if(((User)sess.getAttribute("loggedUser")) != null) {
            return "redirect:/userapp/dashboard/";
        }
        model.addAttribute("userLogin", new UserLogin());
        return "authentication/userLogin";
    }

    @PostMapping("/login/user")
    public String loginUser(@ModelAttribute @Valid UserLogin userLogin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authentication/userLogin";
        }
        User user = authenticationService.authenticateUser(userLogin.getEmail(), userLogin.getPassword());
        if (user == null) {
            model.addAttribute("passwordError", "Podane hasło nie jest poprawne");
            return "authentication/userLogin";
        }
        model.addAttribute("loggedUser", user);
        return "redirect:/userapp/dashboard/";
    }


//--------------- [Business] -------------------------------------------------------------------------------------------

    @GetMapping("/login/business")
    public String loginBusiness(Model model) {
        model.addAttribute("businessLogin", new BusinessLogin());
        return "authentication/businessLogin";
    }

    @PostMapping("/login/business")
    public String loginBusiness(@ModelAttribute @Valid BusinessLogin businessLogin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authentication/businessLogin";
        }
        Business business = authenticationService.authenticateBusiness(businessLogin.getEmail(), businessLogin.getPassword());
        if (business == null) {
            model.addAttribute("passwordError", "Podane hasło nie jest poprawne");
            return "authentication/businessLogin";
        }
        model.addAttribute("loggedBusiness", business);
        return "redirect:/businessapp/dashboard/";
    }


}

