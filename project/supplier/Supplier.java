package project.supplier;

import java.util.ArrayList;
import java.util.List;
import project.product.Product;


public class Supplier {
    private int idSupplier;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<Product> productsId;

    public Supplier(int idSupplier, String name, String address, String email, String phone) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.productsId = new ArrayList<Product>();
    }

    public Supplier(String name2, String address2, String email2, String phone2) {
        this.idSupplier = SupplierRepository.nextIdSupplier();
        this.name = name2;
        this.address = address2;
        this.email = email2;
        this.phone = phone2;
        this.productsId = new ArrayList<Product>();
    }

    protected Supplier() {
        this.idSupplier = 0;
        this.name = null;
        this.address = null;
        this.email = null;
        this.phone = null;
        this.productsId = null;
    }

    public boolean equals(Supplier supplier) {
        return this.idSupplier == supplier.idSupplier;
    }

    void updateSupplier(String change, String newchange) {
        if(change.equals("name")) {
            this.name = newchange;
        }
        else if(change.equals("address")) {
            this.address = newchange;
        }
        else if(change.equals("email")) {
            this.email = newchange;
        }
        else if(change.equals("phone")) {
            this.phone = newchange;
        }
        else {
            System.out.println("Invalid input");
        }
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier= idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone= phone;
    }   

    public List<Product> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Product> productsId) {
        this.productsId = productsId;
    }   

    public void addProduct(Product product) {
        this.productsId.add(product);
    }

    public String display_supplier_info() {
        String result =  "Supplier{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", productsId={";
                for(Product product : productsId) {
                    result += product.display_product_info();
                }
                result += "}";

        return result;
    }
}
