package project.product;

import project.stock.StockRepository;
import project.supplier.Supplier;

public abstract class Food extends Product{

    public Food(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public abstract String display_product_info();
}
