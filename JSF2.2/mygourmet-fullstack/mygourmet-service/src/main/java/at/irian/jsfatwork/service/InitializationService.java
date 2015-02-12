package at.irian.jsfatwork.service;

import at.irian.jsfatwork.domain.Category;
import at.irian.jsfatwork.domain.Dish;
import at.irian.jsfatwork.domain.Provider;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class InitializationService {

    @PersistenceContext(unitName = "mygourmet")
    private EntityManager em;

    public void init() {
        initProviders();
    }

    private void initProviders() {
        em.getTransaction().begin();

        Category catIt = new Category();
        catIt.setName("Italienisch");
        em.persist(catIt);
        Category catGr = new Category();
        catGr.setName("Griechisch");
        em.persist(catGr);
        Category catAt = new Category();
        catAt.setName("Hausmannskost");
        em.persist(catAt);
        Category catMx = new Category();
        catMx.setName("Mexikanisch");
        em.persist(catMx);
        Category catAsian = new Category();
        catAsian.setName("Asiatisch");
        em.persist(catAsian);

        // Create and persist customers
        new CustomerListBuilder().addCustomers(30).persist(em);

        // Initialize providers
        Provider provider = new Provider("Pizzeria Venezia");
        provider.addCategory(catIt);
        provider.getAddress().setZipCode(1010);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Rathausplatz 1");
        provider.getAddress().setCountry("Österreich");
        // Add dish 1
        Dish dish = new Dish();
        dish.setName("Pizza Salami");
        dish.setPrice(7.7);
        dish.setDescription("Tomaten, Käse, Salami");
        dish.setProvider(provider);
        provider.addDish(dish);
        // Add dish 2
        dish = new Dish();
        dish.setName("Pizza Frutti di Mare");
        dish.setPrice(8.8);
        dish.setDescription("Tomaten, Käse, Frutti di Mare");
        dish.setProvider(provider);
        provider.addDish(dish);
        em.persist(provider);
        // Add provider 2
        provider = new Provider("Restaurant Mykonos");
        provider.addCategory(catGr);
        provider.getAddress().setZipCode(1040);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Wiedner Hauptstraße 1");
        provider.getAddress().setCountry("Österreich");
        em.persist(provider);
        // Add provider 3
        provider = new Provider("Zur lustigen Wirtin");
        provider.addCategory(catAt);
        provider.addCategory(catIt);
        provider.getAddress().setZipCode(1010);
        provider.getAddress().setCity("Wien");
        provider.getAddress().setStreet("Stephansplatz 1");
        provider.getAddress().setCountry("Österreich");
        em.persist(provider);

        em.getTransaction().commit();
    }

}
