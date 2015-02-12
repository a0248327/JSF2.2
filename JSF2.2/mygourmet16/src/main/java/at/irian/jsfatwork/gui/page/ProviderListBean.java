package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.service.ProviderService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ProviderListBean {

    @Inject
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
