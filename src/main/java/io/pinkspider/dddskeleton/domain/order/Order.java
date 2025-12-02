package io.pinkspider.dddskeleton.domain.order;

public class Order {
    private Long id;
    private String name;

    public Order(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
