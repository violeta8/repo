package project.product;

import project.stock.StockRepository;
import project.supplier.Supplier;

public class Novel extends Book{

    public Novel(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }


    @Override
    public String display_product_info() {
        return "Novel{" +
                "productId=" + getProductId() +
                ", supplierId=" + getSupplier().getIdSupplier() +
                ", supplier name=" + getSupplier().getName() +
                ", stock=" + StockRepository.getStockQuantity(this) +
                ", price=" + getPrice() + 
                '}';
    }
}
