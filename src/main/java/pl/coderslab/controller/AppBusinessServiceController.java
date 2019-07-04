package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.NewsFeed;
import pl.coderslab.entity.Service;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/businessapp/service")
public class AppBusinessServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewsFeedRepository newsFeedRepository;
    @Autowired
    private OffersRepository offersRepository;
    @Autowired
    private TagRepository tagRepository;

    //TODO move to addingnewcategory to a service view
    @ModelAttribute("categories")
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }

    @GetMapping("/add")
    public String addService(Model model) {
        model.addAttribute("service", new Service());
        return "app/business/businessServiceAdd";
    }

    @PostMapping("/add")
    public String addService(@ModelAttribute @Validated Service service, BindingResult result) {
        if(result.hasErrors()) {
            return "app/business/businessServiceAdd";
        }
        Service savedService = serviceRepository.save(service);
        return "redirect:/businessapp/service/details/" + savedService.getId();
    }

    @RequestMapping("/details/{serviceId}")
    public String serviceDetails(@PathVariable long serviceId, Model model, HttpSession sess) {
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if(((Business)sess.getAttribute("loggedBusiness")).getId() != service.get().getBusiness().getId()) {
                return "redirect:/businessapp/dashboard/";
            }
            model.addAttribute("service", service.get());
            model.addAttribute("categories", categoryRepository.findCategoriesByServiceId(serviceId));
            model.addAttribute("newsFeeds", newsFeedRepository.findNewsFeedByServiceId(serviceId));
            model.addAttribute("offers", offersRepository.findOffersByServiceId(serviceId));
            model.addAttribute("tags", tagRepository.findTagsByServiceId(serviceId));
            return "app/business/businessServiceDetails";
        }
        return "redirect:/businessapp/dashboard/";
    }


}
