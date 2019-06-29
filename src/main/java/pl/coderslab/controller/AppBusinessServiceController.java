package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Service;

@Controller
@RequestMapping("/businessapp/service")
public class AppBusinessServiceController {

    @GetMapping("/add")
    public String addService(Model model) {
        model.addAttribute("service", new Service());
        return "app/business/businessServiceAdd";
    }

}
