package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.service.ProviderService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ProviderListBean {

    @ManagedProperty(value = "#{providerService}")
    private ProviderService providerService;

    private List<Provider> providerList;

    @PostConstruct
    public void init() {
        providerList = providerService.findAll();
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

}
