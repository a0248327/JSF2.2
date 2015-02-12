package at.irian.jsfatwork.service;

import at.irian.jsfatwork.domain.Address;
import at.irian.jsfatwork.domain.Provider;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProviderServiceImpl implements ProviderService, Serializable {

    List<Provider> providers = new ArrayList<Provider>();

    @PostConstruct
    private void initialize() {
        // Add provider 1
        Provider provider = new Provider(1, "Pizzeria Venezia");
        provider.addCategory("cat_it");
        provider.getAddress().setZipCode(1010);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Rathausplatz 1");
        provider.getAddress().setCountry("Österreich");
        providers.add(provider);
        // Add provider 2
        provider = new Provider(2, "Restaurant Mykonos");
        provider.addCategory("cat_gr");
        provider.getAddress().setZipCode(1040);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Wiedner Hauptstraße 1");
        provider.getAddress().setCountry("Österreich");
        providers.add(provider);
        // Add provider 3
        provider = new Provider(3, "Zur lustigen Wirtin");
        provider.addCategory("cat_at");
        provider.addCategory("cat_it");
        provider.getAddress().setZipCode(1010);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Stephansplatz 1");
        provider.getAddress().setCountry("Österreich");
        providers.add(provider);
    }

    public Provider createNew() {
        long newId = providers.size() + 1;
        Provider provider = new Provider(newId);
        provider.setAddress(new Address());
        return provider;
    }

    public boolean save(Provider entity) {
        return true;
    }

    public void delete(Provider entity) {
    }

    public Provider findById(long id) {
        for (Provider p : providers) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Provider> findAll() {
        return providers;
    }

}
