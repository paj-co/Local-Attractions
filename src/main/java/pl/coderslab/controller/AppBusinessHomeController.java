package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/businessapp/dashboard")
public class AppBusinessHomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "app/business/businessDashboard";
    }

}
