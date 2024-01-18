package project.product;

import project.supplier.Supplier;

public abstract class ComputerGame extends Product{

    public ComputerGame(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public abstract String display_product_info();
}
