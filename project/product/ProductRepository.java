package project.product;

import java.util.List;
import java.util.ArrayList;

public class ProductRepository {
    private static List<Product> repository=new ArrayList<Product>();
    private static int nextIdProduct;

    public ProductRepository() {
        repository = new ArrayList<>();
        nextIdProduct = 0;
    }

    public static int nextIdProduct() {
        return nextIdProduct++;
    }

    public static void saveProduct(Product product) {
        repository.add(product);
    }

    public static void updateProduct(int id, String change, String newchange) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Product not found");
        }
        Product product = repository.get(id);
        product.updateProduct(id,change, newchange);
    }

    public static void updateProduct(Product p){
        for(Product product : repository){
            if(product.equals(p)){
                product = p;
            }
        }
    }

    public static Product getProductById(int id) {
        return repository.get(id);
    }

    public static String getAllProducts() {
        String result="";
        for (Product product : repository) {
            result += product.display_product_info()+"\n";
        }
        return result;
    }

    public static void deleteProduct(int id) {
        repository.remove(id);
    }

}
