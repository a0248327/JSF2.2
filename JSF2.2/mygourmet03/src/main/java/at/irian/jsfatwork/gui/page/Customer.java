package at.irian.jsfatwork.gui.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletResponse;

/*
 * customer profile
 */
@ManagedBean
@SessionScoped
public class Customer {
	private String firstName;
	private String lastName;
	private Boolean useCreditCard = Boolean.FALSE;
	private String creditCardType;
	private String creditCardNumber;

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

	public Boolean getUseCreditCard() {
		return useCreditCard;
	}

	public void setUseCreditCard(Boolean useCreditCard) {
		this.useCreditCard = useCreditCard;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String save() {
		return "/showCustomer.xhtml";
	}

	public void useCreditCardChanged(ValueChangeEvent ev) {
		Boolean useCreditCard = (Boolean) ev.getNewValue();
		if (useCreditCard != null) {
			this.useCreditCard = useCreditCard;
		}
		FacesContext.getCurrentInstance().renderResponse();
	}

	public String export() {
        FacesContext fc = FacesContext.getCurrentInstance();
		try {
			// Get writer from servlet context, this won't work with portlets!
			HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
			// Set content type to plain text
			response.setContentType("text/plain");
			// Get writer and print data
			PrintWriter writer = response.getWriter();
			writer.print("First Name: ");
			writer.println(firstName);
			writer.print("Last Name: ");
			writer.println(lastName);
			if (useCreditCard) {
				writer.print("Credit Card Type: ");
				writer.println(creditCardType);
				writer.print("Credit Card Number: ");
				writer.println(creditCardNumber);
			}
			// Skip further lifecycle processing
			fc.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
