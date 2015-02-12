package at.irian.jsfatwork.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import java.util.Set;
import java.util.HashSet;

public class Provider {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @Min(value = 0)
    private Integer stars;
    private Address address = new Address();
    private Set<String> categories = new HashSet<String>();

    public Provider(long id) {
        this.id = id;
    }

    public Provider(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

}
