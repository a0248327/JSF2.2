package at.irian.jsfatwork.service;

import at.irian.jsfatwork.dao.CrudService;
import at.irian.jsfatwork.domain.Address;
import at.irian.jsfatwork.domain.Customer;
import at.irian.jsfatwork.domain.Order;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CrudService crudService;

    @Transactional
    public Customer createNew() {
        return crudService.createNew(Customer.class);
    }

    @Transactional
    public void save(Customer customer) {
        if (customer.isTransient()) {
            crudService.persist(customer);
        } else {
            crudService.merge(customer);
        }
    }

    @Transactional
    public void delete(Customer customer) {
        customer = crudService.merge(customer);
        crudService.delete(customer);
    }

    @Transactional
    public List<Customer> findAll() {
        return crudService.findAll(Customer.class);
    }

    @Transactional
    public Customer findById(long id) {
        return crudService.findById(Customer.class, id);
    }

    public Address createAddress() {
        return crudService.createNew(Address.class);
    }

    @Transactional
    public void saveAddress(Customer customer, Address address) {
        if (address.isTransient()) {
            Customer mergedCustomer = crudService.merge(customer);
            mergedCustomer.addAddress(address);
            crudService.persist(address);
        } else {
            crudService.merge(address);
        }
    }

    @Transactional
    public void deleteAddress(Address address) {
        Customer customer = address.getCustomer();
        customer.removeAddress(address);
        crudService.merge(customer);
        Address addressMerged = crudService.merge(address);
        crudService.delete(addressMerged);
    }

    public Order createOrder() {
        return crudService.createNew(Order.class);
    }

    @Transactional
    public void saveOrder(Customer customer, Order order) {
        order.setOrderDate(new Date());
        Customer mergedCustomer = crudService.merge(customer);
        order.setCustomer(mergedCustomer);
        mergedCustomer.getOrders().add(order);
        crudService.persist(order);
    }

}
