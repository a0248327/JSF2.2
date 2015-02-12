package at.irian.jsfatwork.domain;

import at.irian.jsfatwork.validation.Birthday;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/*
 * customer profile
 */
public class Customer {
    @NotNull
	private String firstName;
    @NotNull
	private String lastName;
    @NotNull
    private String email;
    @NotNull
	private Character gender;
    @Birthday
	private Date birthday;
	private Boolean useCreditCard = Boolean.FALSE;
    @NotNull
	private CreditCardType creditCardType;
    @NotNull
	private String creditCardNumber;
	private List<String> preferredCategories = new ArrayList<String>();
    private List<Address> addresses = new ArrayList<Address>();

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

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getUseCreditCard() {
		return useCreditCard;
	}

	public void setUseCreditCard(Boolean useCreditCard) {
		this.useCreditCard = useCreditCard;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public List<String> getPreferredCategories() {
        return preferredCategories;
    }

	public void setPreferredCategories(List<String> preferredCategories) {
        this.preferredCategories = preferredCategories;
    }

    public List<Address> getAddresses() {
		if (addresses.size() == 0) {
			// Add addresses for example
			Address address1 = new Address(
					1010, "Wien", "Stephansplatz 1", "Austria");
			Address address2 = new Address(
					1040, "Wien", "Karlsplatz 1", "Austria");
			addresses.add(address1);
			addresses.add(address2);
		}
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
