package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Business;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Service;
import pl.coderslab.model.ServiceCategories;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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
    private OfferRepository offerRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private MainCategoryRepository mainCategoryRepository;

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
            model.addAttribute("futureNewsFeeds", newsFeedRepository.findFutureNewsFeedByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("currentNewsFeeds", newsFeedRepository.findCurrentNewsFeedByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("pastNewsFeeds", newsFeedRepository.findPastNewsFeedByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("futureOffers", offerRepository.findFutureOfferByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("currentOffers", offerRepository.findCurrentOfferByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("pastOffers", offerRepository.findPastOfferByServiceId(serviceId, LocalDateTime.now()));
            model.addAttribute("tags", tagRepository.findTagsByServiceId(serviceId));
            return "app/business/businessServiceDetails";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/update/{serviceId}")
    public String updateService(@PathVariable long serviceId, Model model, HttpSession sess) {
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            model.addAttribute("service", service);
            model.addAttribute("serviceId", service.get().getId());
            return "app/business/businessServiceUpdate";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/update/{serviceId}")
    public String updateService(@ModelAttribute @Validated Service service, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("serviceId", service.getId());
            return "app/business/businessServiceUpdate";
        }
        serviceRepository.save(service);
        return "redirect:/businessapp/service/details/" + service.getId();
    }

    @GetMapping("/delete/confirm/{serviceId}")
    public String confirmDeleteService(@PathVariable long serviceId, Model model, HttpSession sess) {
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            model.addAttribute("serviceToDelete", service.get());
            return "app/business/businessConfirmServiceDelete";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/delete/{serviceId}")
    public String deleteService(@PathVariable long serviceId, HttpSession sess) {
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            serviceRepository.delete(service.get());
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/categories/")
    public String addCategoriesToService(@PathVariable long serviceId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            List<Category> serviceCategoriesList = service.get().getCategories();
            List<Category> allCategories = categoryRepository.findCategoriesByOrderByNameAsc();

            allCategories.removeAll(serviceCategoriesList);

            ServiceCategories serviceCategoriesModel = new ServiceCategories();
            serviceCategoriesModel.setServiceId(service.get().getId());
            serviceCategoriesModel.setServiceCategories(serviceCategoriesList);
            serviceCategoriesModel.setRemainingCategories(allCategories);

            model.addAttribute("mainCategories", mainCategoryRepository.findMainCategoriesByOrderByNameAsc());
            model.addAttribute("serviceCategories", serviceCategoriesModel);
            return "app/business/businessAddCategories";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/categories/")
    public String addCategoriesToService(@ModelAttribute ServiceCategories serviceCategories){
        Optional<Service> service = serviceRepository.findById(serviceCategories.getServiceId());
        if(service.isPresent()) {
            if(serviceCategories.getServiceCategories() != null) {
                List<Category> categories = serviceCategories.getServiceCategories();
                if (serviceCategories.getRemainingCategories() != null) {
                    categories.addAll(serviceCategories.getRemainingCategories());
                }

                service.get().setCategories(categories);
                serviceRepository.save(service.get());
            } else if (serviceCategories.getRemainingCategories() != null)  {
                List<Category> categories = serviceCategories.getRemainingCategories();

                service.get().setCategories(categories);
                serviceRepository.save(service.get());
            }
            return "redirect:/businessapp/service/details/" + service.get().getId();
        }
        return "redirect:/businessapp/dashboard/";
    }
}
