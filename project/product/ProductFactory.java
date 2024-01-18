package project.product;

import project.supplier.Supplier;

public interface ProductFactory {
    public Product createProduct(Supplier idProduct, int volume, double price);
}
