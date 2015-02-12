package at.irian.jsfatwork.domain;

import at.irian.jsfatwork.validation.Birthday;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

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
    @Min(value = 1000)
    @Max(value = 99999)
    private Integer zipCode;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @Birthday
	private Date birthday;
	private Boolean useCreditCard = Boolean.FALSE;
    @NotNull
	private CreditCardType creditCardType;
    @NotNull
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

}
