
package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.gui.util.GuiUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProviderBean implements Serializable {

    @Min(value = 0)
    private long id;
    private List<Provider> providerList;
    private Provider provider;

    @PostConstruct
    public void init() {
        providerList = new ArrayList<Provider>();
        Provider provider1 = new Provider(1, "Pizzeria Venezia");
        provider1.addCategory("cat_it");
        provider1.getAddress().setZipCode(1234);
        provider1.getAddress().setCity("Wien");
        provider1.getAddress().setStreet("Rathausplatz 1");
        providerList.add(provider1);
        Provider provider2 = new Provider(2, "Restaurant Mykonos");
        provider2.addCategory("cat_gr");
        providerList.add(provider2);
        Provider provider3 = new Provider(3, "Zur lustigen Wirtin");
        provider3.addCategory("cat_at");
        provider3.addCategory("cat_it");
        providerList.add(provider3);
    }

    public String loadProvider() {
        provider = findProvider(id);
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

    public List<Provider> getProviderList() {
        return providerList;
    }

    public Provider getProvider() {
        return provider;
    }

    private Provider findProvider(long id) {
        for (Provider p : providerList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
