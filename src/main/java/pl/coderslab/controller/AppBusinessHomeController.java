package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Business;
import pl.coderslab.model.BusinessChangePassword;
import pl.coderslab.repository.BusinessRepository;
import pl.coderslab.repository.ServiceRepository;
import pl.coderslab.service.AuthenticationService;
import pl.coderslab.validation.ValidationGroupBusinessChangeData;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/businessapp/dashboard")
public class AppBusinessHomeController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/")
    public String home(HttpSession sess, Model model) {
        long businessId = ((Business) sess.getAttribute("loggedBusiness")).getId();
        model.addAttribute("services", serviceRepository.findServicesByBusinessId(businessId));
        return "app/business/businessDashboard";
    }

    @GetMapping("/data/change")
    public String changeBaseData(Model model, HttpSession sess) {
        Business business = (Business)sess.getAttribute("loggedBusiness");
        model.addAttribute("business", business);
        return "/app/business/businessBaseDataUpdate";
    }

    @PostMapping("/data/change")
    public String changeBaseData(@ModelAttribute("business") @Validated({ValidationGroupBusinessChangeData.class}) Business businessUpdate, BindingResult bindingResult, HttpSession sess, Model model) {
        if(bindingResult.hasErrors()) {
            return "/app/business/businessBaseDataUpdate";
        }
        Optional<Business> business = businessRepository.findById(businessUpdate.getId());
        if(business.isPresent()) {
            if(!business.get().getEmail().equals(businessUpdate.getEmail())) {
                if(authenticationService.checkIfBusinessEmailIsInDatabase(businessUpdate.getEmail())) {
                    model.addAttribute("emailError", "Na ten adres e-mail założono już konto");
                    return "/app/business/businessBaseDataUpdate";
                }
            }
            business.get().setEmail(businessUpdate.getEmail());
            business.get().setNip(businessUpdate.getNip());
            business.get().setRegon(businessUpdate.getRegon());
            business.get().setName(businessUpdate.getName());
            businessRepository.save(business.get());
            sess.setAttribute("loggedBusiness", business.get());
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/password/change")
    public String changePassword(Model model, HttpSession sess) {
        Business loggedBusiness = (Business) sess.getAttribute("loggedBusiness");
        BusinessChangePassword businessChangePassword = new BusinessChangePassword();
        businessChangePassword.setUserId(loggedBusiness.getId());
        businessChangePassword.setEmail(loggedBusiness.getEmail());
        model.addAttribute("businessChangePassword", businessChangePassword);
        return "/app/business/businessBasePasswordChange";
    }

    @PostMapping("/password/change")
    public String changePassword(@ModelAttribute @Valid BusinessChangePassword businessChangePassword, BindingResult bindingResult, HttpSession sess, Model model) {
        if(bindingResult.hasErrors()) {
            return "/app/business/businessBasePasswordChange";
        }
        Business business = authenticationService.authenticateBusiness(businessChangePassword.getEmail(), businessChangePassword.getOldPassword());
        if(business == null) {
            model.addAttribute("passwordError", "Podane hasło nie jest poprawne");
            return "/app/business/businessBasePasswordChange";
        }
        if(!businessChangePassword.getNewPassword().equals(businessChangePassword.getRepeatPassword())) {
            model.addAttribute("reEnterPasswordError", "Nowe hasła nie są tożsame");
            return "/app/business/businessBasePasswordChange";
        }
        String hashedPassword = BCrypt.hashpw(businessChangePassword.getNewPassword(), BCrypt.gensalt());
        business.setPassword(hashedPassword);
        businessRepository.save(business);
        sess.setAttribute("loggedBusiness", business);
        return "redirect:/businessapp/dashboard/";
    }

}
