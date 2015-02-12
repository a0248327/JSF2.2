package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.gui.util.GuiUtil;
import at.irian.jsfatwork.service.ProviderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Min;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class ProviderBean implements Serializable {

    @ManagedProperty(value = "#{providerService}")
    private ProviderService providerService;

    @Min(value = 0)
    private long id;
    private Provider provider;

    public String loadProvider() {
        provider = providerService.findById(id);
        if (provider == null) {
            GuiUtil.addErrorMessage("error_non_existing_provider", id);
        }
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public String save() {
        return "showProvider?faces-redirect=true&includeViewParams=true";
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

}
