package project.customer;

public class Customer {
    private int idCustomer;
    private String name;
    private String address;
    private String email;
    private String phone;
    private double warehouseDistance;
    
    public Customer(int idCustomer, String name, String address, String email, String phone, double warehouseDistance) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.warehouseDistance = warehouseDistance;
    }

    protected Customer() {
        this.idCustomer = 0;
        this.name = "";
        this.address = "";
        this.email = "";
        this.phone = "";
        this.warehouseDistance = 0;
    }

    public Customer(String name2, String address2, String email2, String phone2, double warehouseDistance2) {
        this.idCustomer = CustomerRepository.nextIdCustomer();
        this.name = name2;
        this.address = address2;
        this.email = email2;
        this.phone = phone2;
        this.warehouseDistance = warehouseDistance2;
	}

	public boolean equals(Customer customer) {
        return this.name.equals(customer.name) && this.address.equals(customer.address) && this.email.equals(customer.email) && this.phone.equals(customer.phone) && this.warehouseDistance == customer.warehouseDistance;
    }

    void updateCustomer(String change,String newChange) {
        if (change.equals("name")) {
            this.name = newChange;
        }
        else if (change.equals("address")) {
            this.address = newChange;
        }
        else if (change.equals("email")) {
            this.email = newChange;
        }
        else if (change.equals("phone")) {
            this.phone = newChange;
        }
        else if (change.equals("warehouseDistance")) {
            this.warehouseDistance = Double.parseDouble(newChange);
        }
        else{
            System.out.println("Invalid input");
        }
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public double getWarehouseDistance(){
        return warehouseDistance;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setWarehouseDistance(double warehouseDistance){
        this.warehouseDistance = warehouseDistance;
    }

    public String toString(){
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", warehouseDistance=" + warehouseDistance +
                '}';
    }
}
