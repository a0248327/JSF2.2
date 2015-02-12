package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Address;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AddressBean {
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