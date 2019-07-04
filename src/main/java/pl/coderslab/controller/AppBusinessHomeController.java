package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Business;
import pl.coderslab.repository.ServiceRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/businessapp/dashboard")
public class AppBusinessHomeController {

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping(value = "/")
    public String home(HttpSession sess, Model model) {
        long businessId = ((Business) sess.getAttribute("loggedBusiness")).getId();
        model.addAttribute("services", serviceRepository.findServicesByBusinessId(businessId));
        return "app/business/businessDashboard";
    }

}
