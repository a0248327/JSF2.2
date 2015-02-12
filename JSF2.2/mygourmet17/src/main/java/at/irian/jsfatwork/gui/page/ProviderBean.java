package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.gui.jsf.navigation.NavigationResolver;
import at.irian.jsfatwork.gui.util.GuiUtil;
import at.irian.jsfatwork.service.ProviderService;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Named
@ViewAccessScoped
public class ProviderBean implements Serializable {

    @Inject
    private ProviderService providerService;
    @Inject
    private NavigationResolver navigationResolver;

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
        return goToShowProvider();
    }

    public String goToShowProvider() {
        return navigationResolver.getNavigationOutcome(View.ShowProvider.class)
                .withIncludeViewParams(true)
                .getOutcome();
    }

}
