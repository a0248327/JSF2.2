package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Address;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AddressBean implements Serializable {

    private Address address;

    public String edit(Address address) {
        this.address = address;
        return "/editAddress.xhtml";
    }

	public String save() {
		return "/showCustomer.xhtml";
	}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}