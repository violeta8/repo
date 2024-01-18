package project.product;

import project.supplier.Supplier;

public abstract class Clothing extends Product{

    public Clothing(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public abstract String display_product_info();
}
