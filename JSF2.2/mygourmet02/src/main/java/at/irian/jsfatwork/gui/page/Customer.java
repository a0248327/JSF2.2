package at.irian.jsfatwork.gui.page;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * customer profile
 */
@ManagedBean
@SessionScoped
public class Customer {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String save() {
		return "/showCustomer.xhtml";
	}

}
