package com.somosbooking.somosBack.model;


import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
@Table(name="cart",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "idCart")
    }
)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcart", nullable = false)
    private int idCart;
    //@Column(name="idClient", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="idclient", nullable = false,
        foreignKey = @ForeignKey(name="fk_idCliente"))
    private User client;
    @Column(name="cartactive", nullable = false)
    private boolean cartActive;
    @Column(name="total")
    private double total;


    public Cart(int idCart, User client, boolean cartActive, double total) {
        this.idCart = idCart;
        this.client = client;
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

    public User getIdClient() {
        return client;
    }

    public void setIdClient(User client) {
        this.client = client;
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
