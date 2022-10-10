package com.example.moducafe.Adapter;

public class OrderDto {
    private Long id;
    private String orderUser;
    private int quantity;
    private int price;

    public OrderDto(Long id, String orderUser, int quantity, int price) {
        setId(id);
        setOrderUser(orderUser);
        setQuantity(quantity);
        setPrice(price);
    }

    public Long getId() { return this.id; }
    public String getOrderUser() { return this.orderUser; }
    public int getQuantity() { return this.quantity; }
    public int getPrice() { return this.price; }

    public void setId(Long id) { this.id = id; }
    public void setOrderUser(String orderUser) { this.orderUser = orderUser; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(int price) { this.price = price; }
}
