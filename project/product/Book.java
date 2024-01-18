package project.product;

import project.supplier.Supplier;

public abstract class Book extends Product{

    public Book(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public abstract String display_product_info();
}
