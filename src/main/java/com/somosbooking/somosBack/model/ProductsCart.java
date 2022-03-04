package com.somosbooking.somosBack.model;


import javax.persistence.*;

@Entity
@Table(name="productscart",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "idCart")
    }
)
public class ProductsCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdCartProducts", nullable = false)
    private int IdCartProducts;
    //@Column(name="idCart", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCart", nullable = false,
            foreignKey = @ForeignKey(name="fk_idCart"))
    private Cart idCart;
    //@Column(name="idArticle", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idArticle", nullable = false,
            foreignKey = @ForeignKey(name="fk_idArticle"))
    private article idArticle;
    @Column(name="amount", nullable = false)
    private int amount;
    @Column(name="total", nullable = false)
    private double total;

    public ProductsCart(int idCartProducts, Cart idCart, article idArticle, int amount, double total) {
        IdCartProducts = idCartProducts;
        this.idCart = idCart;
        this.idArticle = idArticle;
        this.amount = amount;
        this.total = total;
    }

    public ProductsCart() {
    }

    public int getIdCartProducts() {
        return IdCartProducts;
    }

    public void setIdCartProducts(int idCartProducts) {
        IdCartProducts = idCartProducts;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    public article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(article idArticle) {
        this.idArticle = idArticle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
