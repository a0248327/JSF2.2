package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Address;
import at.irian.jsfatwork.service.CustomerService;
import org.apache.myfaces.extensions.cdi.core.api.config.view.ViewConfig;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewAccessScoped
public class CustomerBean extends CustomerBeanBase {

    @Inject
    private CustomerService customerService;

    private boolean collapsed = false;
    private Address address;

    @PostConstruct
    public void init() {
        super.init();
    }

    public Class<? extends ViewConfig> showCustomer(long id) {
        this.customer = customerService.findById(id);
        return View.ShowCustomer.class;
    }

	public Class<? extends ViewConfig> saveCustomer() {
        customerService.save(customer);
        return View.ShowCustomer.class;
    }

	public Class<? extends ViewConfig> cancelCustomer() {
        return View.ShowCustomer.class;
    }

	public Class<? extends ViewConfig> createAddress() {
        this.address = customerService.createAddress();
        return View.EditAddress.class;
    }

    public Class<? extends ViewConfig> editAddress(Address address) {
        this.address = address;
        return View.EditAddress.class;
    }

    public Class<? extends ViewConfig> saveAddress() {
        customerService.saveAddress(customer, address);
        this.customer = customerService.findById(this.customer.getId());
        this.address = null;
        return View.ShowCustomer.class;
    }

    public void deleteAddress(Address address) {
        customerService.deleteAddress(address);
    }

    public Class<? extends ViewConfig> cancelAddress() {
        this.address = null;
        return View.ShowCustomer.class;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    public Address getAddress() {
        return address;
    }

}
