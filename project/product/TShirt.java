package project.product;

import project.stock.StockRepository;
import project.supplier.Supplier;

public class TShirt extends Clothing{

    public TShirt(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public String display_product_info() {
        return "TShirt{" +        
                "productId=" + getProductId() +
                ", supplierId=" + getSupplier().getIdSupplier() +
                ", supplier name=" + getSupplier().getName() +
                ", productId=" + getProductId() +
                ", stock=" + StockRepository.getStockQuantity(this) +
                ", price=" + getPrice() + 
                '}';
    }
}
