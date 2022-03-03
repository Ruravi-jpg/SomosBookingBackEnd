package com.somosbooking.somosBack.model;


import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCart", nullable = false)
    private int idCart;
    @Column(name="idClient", nullable = false)
    private int idClient;
    @Column(name="cartActive", nullable = false)
    private boolean cartActive;
    @Column(name="total", nullable = false)
    private double total;


    public Cart(int idCart, int idClient, boolean cartActive, double total) {
        this.idCart = idCart;
        this.idClient = idClient;
        this.cartActive = cartActive;
        this.total = total;
    }

    public Cart() {
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public boolean isCartActive() {
        return cartActive;
    }

    public void setCartActive(boolean cartActive) {
        this.cartActive = cartActive;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
