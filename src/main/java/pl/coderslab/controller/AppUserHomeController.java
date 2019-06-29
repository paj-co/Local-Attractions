package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userapp/dashboard")
public class AppUserHomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "app/user/userDashboard";
    }

}
