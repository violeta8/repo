package project.stock;

import project.product.Product;

public class Stock {
    private int quantity;//first int is product id, second int is quantity
    private Product product;

    public Stock(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public Stock() {
        this.quantity = 0;
        this.product = null;
    }

    public Product getProduct() {
        return product;
    }

    public void addProduct(Product product, int quantity) {
        this.product = product;
        this.quantity += quantity;
    }

    public void removeProduct(Product product, int quantity) {
        this.product = product;
        this.quantity -= quantity;
    }

    public void updateStock(int q){
        this.quantity = q;
    }

    public int getAvailableStock(Product product) {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String display_stock_info() {
        return "Stock{" +
                "quantity=" + quantity +
                ", product=" + product.display_product_info() +
                '}';
    }
}
