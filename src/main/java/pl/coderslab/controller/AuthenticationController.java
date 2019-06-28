package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.User;
import pl.coderslab.model.ViewMode;
import pl.coderslab.service.AuthenticationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/authentication")
@SessionAttributes("loggedUser")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


//--------------- [User] -------------------------------------------------------------------------------------------
    @GetMapping("/login/user")
    public String loginUser(Model model) {
        model.addAttribute("viewMode", new ViewMode());
        return "authentication/userLogin";
    }

    @PostMapping("/login/user")
    public String loginUser(@ModelAttribute @Valid ViewMode viewMode, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authentication/userLogin";
        }
        User user = authenticationService.authenticateUser(viewMode.getEmail(), viewMode.getPassword());
        if (user == null) {
            emailErrorMessage(viewMode,model);
        }
        model.addAttribute("loggedUser", user);
        return "app/user/userDashboard";
    }

    //TODO Logout
    @RequestMapping("/logout")
    public String logout(HttpSession sess) {
        if((User)sess.getAttribute("loggedUser") != null) {
            sess.setAttribute("loggedUser", null);
        }
        return "/";
    }

//--------------- [Business] -------------------------------------------------------------------------------------------

    @GetMapping("/login/business")
    public String loginBusiness(Model model) {
        model.addAttribute("viewMode", new ViewMode());
        return "authentication/businessLogin";
    }

    @PostMapping("/login/business")
    public String loginBusiness(@ModelAttribute @Valid ViewMode viewMode, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "authentication/businessLogin";
        }
        Business business = authenticationService.authenticateBusiness(viewMode.getEmail(), viewMode.getPassword());
        if (business == null) {
            emailErrorMessage(viewMode,model);
        }
        model.addAttribute("loggedBusiness", business);
        return "app/business/businessDashboard";
    }

//--------------- [common] ---------------------------------------------------------------------------------------------

    private String emailErrorMessage (ViewMode viewMode, Model model) {
        model.addAttribute("passwordError", "Podane hasło nie jest poprawne");
        ViewMode passwordErrorViewMode = new ViewMode();
        passwordErrorViewMode.setEmail(viewMode.getEmail());
        model.addAttribute("viewMode", passwordErrorViewMode);
        return "authentication/login";
    }







}

