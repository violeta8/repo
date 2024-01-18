package project.product;

import project.supplier.Supplier;

public abstract class Product {
    private int productId;
    private Supplier supplier;
    private int volume;
    private double price;

    public Product(Supplier supplier, int volume, double price) {
        productId = ProductRepository.nextIdProduct();
        this.supplier = supplier;
        this.volume = volume;
        this.price = price;
    }

    boolean equals (Product product) {
        return this.productId == product.productId;
    }

    public void updateProduct(int id,String change,String newchange) {
        //todo maybe add the possibility to change the supplier
        if (change.equals("price")) {
            this.price = Double.parseDouble(newchange);
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getProductId() {
        return productId;
    }
 

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public double calculate_discount(int quantity, int month) {
        if (month == 1 || month == 2 || month == 12) {
            return 0.9 * quantity * price;
        }
        else if(month == 3 || month == 4 || month == 5) {
            return 0.5 * quantity * price;
        }
        else if(month == 6 || month == 7 || month == 8) {
            return 0.2 * quantity * price;
        }
        else if(month == 9 || month == 10 || month == 11) {
            return 0.1 * quantity * price;
        }
        else {
            return 1;
        }
    }

    public abstract String display_product_info();

}
