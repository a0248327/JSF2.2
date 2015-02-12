package at.irian.jsfatwork.service;

import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.domain.Customer;
import at.irian.jsfatwork.domain.Address;

import java.util.List;

public interface CustomerService {

    Customer createNew();

    boolean save(Customer customer);

    void delete(Customer customer);

    List<Customer> findAll();

    Customer findById(long id);

    Address createAddress();

    void saveAddress(Customer customer, Address address);

    void deleteAddress(Customer customer, Address address);

}