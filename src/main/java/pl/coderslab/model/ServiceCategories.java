package pl.coderslab.model;

import pl.coderslab.entity.Category;

import java.util.List;

public class ServiceCategories {

    private Long serviceId;
    private List<Category> serviceCategories;
    private List<Category> remainingCategories;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public List<Category> getServiceCategories() {
        return serviceCategories;
    }

    public void setServiceCategories(List<Category> serviceCategories) {
        this.serviceCategories = serviceCategories;
    }

    public List<Category> getRemainingCategories() {
        return remainingCategories;
    }

    public void setRemainingCategories(List<Category> remainingCategories) {
        this.remainingCategories = remainingCategories;
    }
}
