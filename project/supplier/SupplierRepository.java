package project.supplier;

import java.util.ArrayList;
import java.util.List;

import project.product.Product;

public class SupplierRepository {
    private static List<Supplier> repository=new ArrayList<Supplier>();
    private static int nextIdSupplier;

    public SupplierRepository() {
        repository = new ArrayList<Supplier>();
        nextIdSupplier = 0;
    }

    public static int nextIdSupplier() {
        return nextIdSupplier++;
    }

    public static void saveSupplier(Supplier supplier) {
        repository.add(supplier);
    }

    public static Supplier getSupplierById(int id) {
        return repository.get(id);
    }

    public static void updateSupplier(int id, String change, String newchange) {//this will change the supplier's info
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Supplier not found");
        }
        Supplier supplier = repository.get(id);
        supplier.updateSupplier(change,newchange);
    }

    public static void updateSupplier(int id,Product product) {//this one will add a product to the supplier's list
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Supplier not found");
        }
        Supplier supplier = repository.get(id);
        supplier.addProduct(product);
    }

    public static Supplier getSupplierByName(String name) {
        for (Supplier supplier : repository) {
            if (supplier.getName().equals(name)) {
                return supplier;
            }
        }
        throw new IllegalArgumentException("Supplier does not exist");
    }

    public static String getAllSuppliers() {//todo deberia de hacerlo string?
        String result="";
        for (Supplier supplier : repository) {
            result += supplier.display_supplier_info() + "\n";
        }
        return result;
    }

    public static void deleteSupplier(int id) {
        repository.remove(id);
    }
    
}
