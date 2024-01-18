package project.product;

import project.stock.StockRepository;
import project.supplier.Supplier;

public class Zelda extends ComputerGame{

    public Zelda(Supplier supplierId, int volume, double price) {
        super(supplierId, volume, price);
    }

    @Override
    public String display_product_info() {
        return "Zelda{" +        
                "productId=" + getProductId() +
                ", supplierId=" + getSupplier().getIdSupplier() +
                ", supplier name=" + getSupplier().getName() +
                ", stock=" + StockRepository.getStockQuantity(this) +
                ", price=" + getPrice() + 
                '}';
    }
}
