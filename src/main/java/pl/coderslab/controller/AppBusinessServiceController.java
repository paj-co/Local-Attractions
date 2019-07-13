package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.entity.*;
import pl.coderslab.model.ServiceCategories;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
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
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private CommuneRepository communeRepository;
    @Autowired
    private LocalityRepository localityRepository;

    @ModelAttribute("provinces")
    public List<Province> provinceList() {
        return provinceRepository.findProvincesByOrderByNameAsc();
    }

    @ModelAttribute("districts")
    public List<District> districtList() {
        return districtRepository.findDistrictsByOrderByNameAsc();
    }

    @ModelAttribute("communes")
    public List<Commune> communeList() {
        return communeRepository.findCommunesByOrderByNameAsc();
    }

    @ModelAttribute("localities")
    public List<Locality> localityList() {
        return localityRepository.findLocalitiesByOrderByNameAsc();
    }

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
    public String addService(@ModelAttribute @Validated Service service, BindingResult result, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        if(result.hasErrors()) {
            return "app/business/businessServiceAdd";
        }

        if(multipartFile != null) {
            try {
                byte[] bytes = multipartFile.getBytes();
                byte[] encodeBase64Bytes = Base64.getEncoder().encode(bytes);
                service.setMainImage(new String(encodeBase64Bytes, StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            model.addAttribute("futureNewsFeeds", newsFeedRepository.findFutureNewsFeedByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("currentNewsFeeds", newsFeedRepository.findCurrentNewsFeedByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("pastNewsFeeds", newsFeedRepository.findPastNewsFeedByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("futureOffers", offerRepository.findFutureOfferByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("currentOffers", offerRepository.findCurrentOfferByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("pastOffers", offerRepository.findPastOfferByServiceId(serviceId, LocalDate.now()));
            model.addAttribute("tags", tagRepository.findTagsByServiceIdOrderByNameAsc(serviceId));

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
    public String updateService(@ModelAttribute @Validated Service service, BindingResult result, Model model, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        if(result.hasErrors()) {
            model.addAttribute("serviceId", service.getId());
            return "app/business/businessServiceUpdate";
        }
        try {
            if(multipartFile != null && multipartFile.getBytes().length > 0) {
                byte[] bytes = multipartFile.getBytes();
                byte[] encodeBase64Bytes = Base64.getEncoder().encode(bytes);
                service.setMainImage(new String(encodeBase64Bytes, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.setCategories(categoryRepository.findCategoriesByServiceId(service.getId()));
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
            return "app/business/businessServiceConfirmDelete";
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
            return "app/business/businessCategoriesAdd";
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

    @GetMapping("/{serviceId}/news/add")
    public String addNewsToService(@PathVariable long serviceId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            model.addAttribute("newsFeed", new NewsFeed());
            model.addAttribute("serviceId", service.get().getId());
            return "app/business/businessNewsAdd";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/news/add")
    public String addNewsToService(@PathVariable long serviceId, @ModelAttribute @Valid NewsFeed newsFeed, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "app/business/businessNewsAdd";
        }
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if(newsFeed.getStarts().isAfter(newsFeed.getEnds())) {
                model.addAttribute("dateError", "Data początkowa musi być mniejsza bądź równa dacie zakończenia");
                return "app/business/businessNewsAdd";
            }
            newsFeedRepository.save(newsFeed);
            return "redirect:/businessapp/service/details/" + service.get().getId();
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/news/update/{newsId}")
    public String updateServiceNews(@PathVariable long serviceId, @PathVariable long newsId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<NewsFeed> newsFeed = newsFeedRepository.findById(newsId);
            if(newsFeed.isPresent()) {
                model.addAttribute("newsFeed", newsFeed.get());
                return "app/business/businessNewsUpdate";
            }
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/news/update/{newsId}")
    public String updateServiceNews(@PathVariable long serviceId, @ModelAttribute @Valid NewsFeed newsFeed, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "app/business/businessNewsUpdate";
        }
        if(newsFeed.getStarts().isAfter(newsFeed.getEnds())) {
            model.addAttribute("dateError", "Data początkowa musi być mniejsza bądź równa dacie zakończenia");
            return "app/business/businessNewsUpdate";
        }
        newsFeedRepository.save(newsFeed);
        return "redirect:/businessapp/service/details/" + serviceId;
    }

    @GetMapping("/{serviceId}/news/delete/confirm/{newsId}")
    public String confirmDeleteServiceNews(@PathVariable long serviceId, @PathVariable long newsId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<NewsFeed> newsFeed = newsFeedRepository.findById(newsId);
            if(newsFeed.isPresent()) {
                model.addAttribute("newsFeed", newsFeed.get());
                model.addAttribute("serviceId", service.get().getId());
                return "app/business/businessNewsDeleteConfirm";
            }
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/news/delete/{newsId}")
    public String deleteServiceNews(@PathVariable long serviceId, @PathVariable long newsId, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<NewsFeed> newsFeed = newsFeedRepository.findById(newsId);
            newsFeed.ifPresent(feed -> newsFeedRepository.delete(feed));
            return "redirect:/businessapp/service/details/" + service.get().getId();
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/offer/add")
    public String addOfferToService(@PathVariable long serviceId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            model.addAttribute("offer", new Offer());
            model.addAttribute("serviceId", service.get().getId());
            return "app/business/businessOfferAdd";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/offer/add")
    public String addOfferToService(@PathVariable long serviceId, @ModelAttribute @Valid Offer offer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "app/business/businessOfferAdd";
        }
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if(offer.getStarts().isAfter(offer.getEnds())) {
                model.addAttribute("dateError", "Data początkowa musi być mniejsza bądź równa dacie zakończenia");
                return "app/business/businessOfferAdd";
            }
            offerRepository.save(offer);
            return "redirect:/businessapp/service/details/" + service.get().getId();
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/offer/update/{offerId}")
    public String updateServiceOffer(@PathVariable long serviceId, @PathVariable long offerId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<Offer> offer = offerRepository.findById(offerId);
            if(offer.isPresent()) {
                model.addAttribute("offer", offer.get());
                return "app/business/businessOfferUpdate";
            }
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/offer/update/{offerId}")
    public String updateServiceOffer(@PathVariable long serviceId, @ModelAttribute @Valid Offer offer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "app/business/businessOfferUpdate";
        }
        if(offer.getStarts().isAfter(offer.getEnds())) {
            model.addAttribute("dateError", "Data początkowa musi być mniejsza bądź równa dacie zakończenia");
            return "app/business/businessOfferUpdate";
        }
        offerRepository.save(offer);
        return "redirect:/businessapp/service/details/" + serviceId;
    }

    @GetMapping("/{serviceId}/offer/delete/confirm/{offerId}")
    public String confirmDeleteServiceOffer(@PathVariable long serviceId, @PathVariable long offerId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<Offer> offer = offerRepository.findById(offerId);
            if(offer.isPresent()) {
                model.addAttribute("offer", offer.get());
                model.addAttribute("serviceId", service.get().getId());
                return "app/business/businessOfferDeleteConfirm";
            }
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/offer/delete/{offerId}")
    public String deleteServiceOffer(@PathVariable long serviceId, @PathVariable long offerId, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<Offer> offer = offerRepository.findById(offerId);
            offer.ifPresent(feed -> offerRepository.delete(feed));
            return "redirect:/businessapp/service/details/" + service.get().getId();
        }
        return "redirect:/businessapp/dashboard/";
    }

    @GetMapping("/{serviceId}/tags")
    public String addTagsToService(@PathVariable long serviceId, Model model, HttpSession sess){
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            List<Tag> serviceTagsList = tagRepository.findTagsByServiceIdOrderByNameAsc(service.get().getId());
            Tag tag = new Tag();
            model.addAttribute("serviceId", service.get().getId());
            model.addAttribute("tag", tag);
            model.addAttribute("tagList", serviceTagsList);
            return "app/business/businessTagsAdd";
        }
        return "redirect:/businessapp/dashboard/";
    }

    @PostMapping("/{serviceId}/tags")
    public String addTagsToService(@ModelAttribute @Valid Tag tag, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "app/business/businessTagsAdd";
        }
        tagRepository.save(tag);
        return "redirect:/businessapp/service/" + tag.getService().getId() + "/tags";
    }


    @RequestMapping("/{serviceId}/tag/delete/{tagId}")
    public String deleteServiceTag(@PathVariable long serviceId, @PathVariable long tagId, HttpSession sess) {
        Optional<Service> service = serviceRepository.findById(serviceId);
        if(service.isPresent()) {
            if (!((Business) sess.getAttribute("loggedBusiness")).getId().equals(service.get().getBusiness().getId())) {
                return "redirect:/businessapp/dashboard/";
            }
            Optional<Tag> tag = tagRepository.findById(tagId);
            if(tag.isPresent()) {
                tagRepository.delete(tag.get());
                return "redirect:/businessapp/service/" + tag.get().getService().getId() + "/tags";
            }
        }
        return "redirect:/businessapp/dashboard/";
    }

}
