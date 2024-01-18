package project.customer;

import java.util.List;
import java.util.ArrayList;

public class CustomerRepository {
    private static List<Customer> repository=new ArrayList<Customer>();
    private static int nextIdCustomer=0;

    public CustomerRepository() {
        repository = new ArrayList<Customer>();
        nextIdCustomer = 0;
    }

    public static int nextIdCustomer() {
        return nextIdCustomer++;
    }

    public static void saveCustomer(Customer customer) {
        repository.add(customer);
    }

    public static void updateCustomer(int id,String change,String newchange) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError ("Customer not found");
        }
        Customer customer = repository.get(id);
        customer.updateCustomer(change,newchange);
    }

    public static Customer getCustomerById(int id) {
        return repository.get(id);
    }

    public static Customer getCustomerByName(String name) {
        for (Customer customer : repository) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public static String getAllCustomers() {
        String result="";
        for (Customer customer : repository) {
            result += customer.toString()+"\n";
            
        }
        return result;
    }

    public static void deleteCustomer(Customer customer) {
        repository.remove(customer);
    }
    //todo get this fixed
}
