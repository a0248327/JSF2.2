package at.irian.jsfatwork.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class Address {
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    @Min(value = 1000)
    @Max(value = 99999)
    private Integer zipCode;
    @NotNull
    private String country;

    public Address() {
		super();
	}

	public Address(Integer zipCode, String city, String street, String country) {
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.country = country;
	}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
