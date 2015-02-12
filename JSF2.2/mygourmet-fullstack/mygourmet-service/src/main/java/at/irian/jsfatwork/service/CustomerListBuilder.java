package at.irian.jsfatwork.service;

import at.irian.jsfatwork.domain.Address;
import at.irian.jsfatwork.domain.Customer;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Kurz
 */
public class CustomerListBuilder {

    private static final String[] firstNames;
    private static final Character[] genders;
    private static final String[] lastNames;
    private static final Integer[] zipCodes;
    private static final String[] cities;
    private static final String[] streets;

    static {
        firstNames = new String[]{"Paul", "Lena", "Anna", "Ben", "Max", "Sofia", "Lisa", "Jonas"};
        genders = new Character[]{'m', 'f', 'f', 'm', 'm', 'f', 'f', 'm'};
        lastNames = new String[]{"Berger", "Meier", "Huber", "Moser", "Schmitz", "Steiner", "Weber"};
        zipCodes = new Integer[]{1010, 1020, 1030, 4020, 8020};
        cities = new String[]{"Wien", "Wien", "Wien", "Linz", "Graz"};
        streets = new String[]{"Hauptstraße 1", "Poststraße 2", "Bahnhofstraße 4", "Europastraße 3", "Nordstraße 7", "Marktstraße 10"};
    }

    private final List<Customer> customers;

    public CustomerListBuilder() {
        this.customers = new ArrayList<Customer>();
    }

    public CustomerListBuilder addCustomers(int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            String firstName = getItem(firstNames, i);
            String lastName = getItem(lastNames, i);
            String email = String.format("%s.%s@server.at", firstName.toLowerCase(), lastName.toLowerCase());

            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setGender(genders[i % 8]);

            Address address = new Address(zipCodes[i % 5], cities[i % 5], streets[i % 6], "Österreich");
            customer.getAddresses().add(address);

            customers.add(customer);
        }

        return this;
    }

    public List<Customer> getList() {
        return customers;
    }

    public void persist(EntityManager em) {
        for (Customer customer : customers) {
            em.persist(customer);
        }
    }

    private <T> T getItem(T[] items, int i) {
        return items[i % items.length];
    }
}
