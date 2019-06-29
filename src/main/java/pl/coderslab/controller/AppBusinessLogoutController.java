package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Business;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/businessapp/logout")
public class AppBusinessLogoutController {

    @RequestMapping("/")
    public String logout(HttpSession sess) {
        if((Business)sess.getAttribute("loggedBusiness") != null) {
            sess.invalidate();
        }
        return "redirect:/";
    }

}

