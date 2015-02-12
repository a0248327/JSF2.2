package at.irian.jsfatwork.domain;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.HashSet;

public class Provider {
    @NotNull
    private long id;
    @NotNull
    private String name;
    private Address address = new Address();
    private Set<String> categories = new HashSet<String>();

    public Provider(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
