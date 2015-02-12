package at.irian.jsfatwork.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "DISH")
@SequenceGenerator(name = "DISH_SEQUENCE_GENERATOR", sequenceName = "DISH_SEQUENCE")
public class Dish extends AbstractBaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISH_SEQUENCE_GENERATOR")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    @Size(max = 50)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    @Min(0)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
    private Provider provider;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
