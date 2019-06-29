package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userapp/logout")
public class AppUserLogoutController {

    @RequestMapping("/")
    public String logout(HttpSession sess) {
        if((User)sess.getAttribute("loggedUser") != null) {
            sess.invalidate();
        }
        return "redirect:/";
    }

}
