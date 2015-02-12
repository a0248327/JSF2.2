package at.irian.jsfatwork.service.impl;

import at.irian.jsfatwork.domain.Address;
import at.irian.jsfatwork.domain.Customer;
import at.irian.jsfatwork.service.CustomerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    List<Customer> customers = new ArrayList<Customer>();

    @PostConstruct
    private void initialize() {
    }

    public Customer createNew() {
        long newId = customers.size() + 1;
        Customer customer = new Customer(newId);
        Address address = new Address();
        customer.getAddresses().add(address);
        return customer;
    }

    public boolean save(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        return true;
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public Customer findById(long id) {
        for (Customer p : customers) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Address createAddress() {
        return new Address();
    }

    public void saveAddress(Customer customer, Address address) {
        if (!customer.getAddresses().contains(address)) {
            customer.getAddresses().add(address);
        }
    }

    public void deleteAddress(Customer customer, Address address) {
        customer.getAddresses().remove(address);
    }

}