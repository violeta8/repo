package project;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import project.customer.*;
import project.customer.CustomerRepository;
import project.packaging.Packaging;
import project.product.*;
import project.product.ProductRepository;
import project.shipment.*;
import project.stock.Stock;
import project.stock.StockRepository;
import project.supplier.*;
import project.supplier.SupplierRepository;
import project.transport.*;
import project.transport.TransportRepository;
import project.transport.truck.TruckFactory;
import project.transport.ship.ShipFactory;
import project.transport.plane.PlaneFactory;
import project.shipment.ShipmentDecorator;



/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    public static void index(){
        System.out.println("Select what do you want to do:");
        System.out.println( "1. Customers" );
        System.out.println( "2. Suppliers" );
        System.out.println( "3. Transports" );
        System.out.println( "4. Products" );
        System.out.println( "5. Shipments" );
        System.out.println( "6. Stock");
    }

    public static void CustomerMenu(){
        System.out.println( "You are in Customer's MENU" );
        int choice1 = 0;
        System.out.println( "What would you like to do?" );
        System.out.println( "1. Add a customer" );
        System.out.println( "2. Remove a customer" );
        System.out.println( "3. Update a customer" );
        System.out.println( "4. View all customers" );
        System.out.println( "5. View a specific customer" );
        choice1 = scanner.nextInt(); 
        scanner.nextLine();
        switch(choice1) {
            case 1:
                System.out.println( "You have selected to add a customer" );
                System.out.println( "Please enter the customer's name" );
                String name1= scanner.nextLine();
                System.out.println( "Please enter the customer's address" );
                String address = scanner.nextLine();
                System.out.println( "Please enter the customer's email" );
                String email = scanner.nextLine();
                System.out.println( "Please enter the customer's phone number" );
                String phone = scanner.nextLine();
                System.out.println( "Please enter the customer's warehouse distance" );
                double warehouseDistance = scanner.nextDouble();
                scanner.nextLine();
                Customer customer = new Customer(name1, address, email, phone, warehouseDistance);
                CustomerRepository.saveCustomer(customer);
                break;

            case 2: 
                System.out.println( "You have selected to remove a customer" );
                System.out.println( "Please enter the customer's name" );
                String name = scanner.nextLine();
                CustomerRepository.deleteCustomer(CustomerRepository.getCustomerByName(name));
                System.out.println( "The customer has been removed successfully!" );
                break;
            case 3:
                System.out.println( "You have selected to update a customer" );
                System.out.println( "Please enter the customer's id" );
                int id1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( "Please enter what would you like to change" );
                String change = scanner.nextLine();
                String newchange = scanner.nextLine();
                CustomerRepository.updateCustomer(id1, change, newchange);
                System.out.println("The customer has been changed successfully!");
                break;
            case 4:
                System.out.println( "You have selected to view all customers" );
                System.out.println( "This is the List of customers that are available at the moment:" );
                System.out.println( CustomerRepository.getAllCustomers() );
                break;
            case 5:
                System.out.println( "You have selected to view a specific customer" );
                System.out.println( "Please enter the customer's id" );
                int id2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( CustomerRepository.getCustomerById(id2) );
                break;
            default:
                break;
            }
    }

    public static void ProductMenu(){
        System.out.println( "You are in the PRODUCT'S MENU" );
        System.out.println( "What would you like to do?" );
        System.out.println( "1. Add a product" );
        System.out.println( "2. Remove a product" );
        System.out.println( "3. Update a product" );
        System.out.println( "4. View all products" );
        System.out.println( "5. View a specific product" );
        int choice2 = scanner.nextInt();
        scanner.nextLine();
        switch (choice2) {
            case 1:
                System.out.println( "You have selected to add a product" );
                System.out.println("First you need to select the name of the Supplier that will be the one supplying");                        
                String supplier = scanner.nextLine();
                Supplier s= SupplierRepository.getSupplierByName(supplier);
                System.out.println( "Please enter what type of product would you like to add:" );
                System.out.println( "1. Novel" );
                System.out.println( "2. Textbook" );
                System.out.println( "3. Minecraft" );
                System.out.println( "4. Zelda" );
                System.out.println( "5. Tablet" );
                System.out.println( "6. Smartphone" );
                System.out.println( "7. T-Shirt" );
                System.out.println( "8. Pants" );
                System.out.println( "9. Milk" );
                System.out.println( "10. Cheese" );
                System.out.println( "11. Washing machine" );
                System.out.println( "12. Fridge" );
                int choice3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( "Please enter the new products's price" );
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Please enter the new products's volume");
                        int volume = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter the new products's units");
                        int units = scanner.nextInt();
                        scanner.nextLine();
                switch(choice3){
                    case 1:
                        Novel novel = new Novel(s, volume, price);
                        ProductRepository.saveProduct(novel);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),novel);
                        Stock stock = new Stock(novel,units);
                        StockRepository.saveStock(stock);
                        break;

                    case 2:
                        
                        Textbook textbook = new Textbook(s, volume, price);
                        ProductRepository.saveProduct(textbook);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),textbook);
                        Stock stock1 = new Stock(textbook, units);
                        StockRepository.saveStock(stock1);
                        break;

                    case 3:
                        
                        Minecraft minecraft = new Minecraft(s, volume, price);
                        ProductRepository.saveProduct(minecraft);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),minecraft);
                        Stock stock2 = new Stock(minecraft, units); 
                        StockRepository.saveStock(stock2);
                        break;

                    case 4:
                        
                        Zelda zelda = new Zelda(s, volume, price); 
                        ProductRepository.saveProduct(zelda);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),zelda);
                        Stock stock3 = new Stock(zelda, units);
                        StockRepository.saveStock(stock3);
                        break;

                    case 5:
                        
                        Tablet tablet = new Tablet(s, volume, price);
                        ProductRepository.saveProduct(tablet);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),tablet);
                        Stock stock4 = new Stock(tablet, units);
                        StockRepository.saveStock(stock4);
                        break;

                    case 6:
                        SmartPhone smartphone = new SmartPhone(s, volume, price);
                        ProductRepository.saveProduct(smartphone);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),smartphone);
                        Stock stock5 = new Stock(smartphone, units);
                        StockRepository.saveStock(stock5);
                        break;

                    case 7:
                        TShirt tshirt = new TShirt(s, volume, price);
                        ProductRepository.saveProduct(tshirt);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),tshirt);
                        Stock stock6 = new Stock(tshirt, units);
                        StockRepository.saveStock(stock6);
                        break;

                    case 8:
                        Pants pants = new Pants(s, volume, price);
                        ProductRepository.saveProduct(pants);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),pants);
                        Stock stock7 = new Stock(pants, units);
                        StockRepository.saveStock(stock7);
                        break;

                    case 9:
                        Milk milk = new Milk(s, volume, price);
                        ProductRepository.saveProduct(milk);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),milk);
                        Stock stock8 = new Stock(milk, units);
                        StockRepository.saveStock(stock8);
                        break;

                    case 10:
                        Cheese cheese = new Cheese(s, volume, price);
                        ProductRepository.saveProduct(cheese);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),cheese);
                        Stock stock9 = new Stock(cheese, units);
                        StockRepository.saveStock(stock9);
                        break;
                    case 11:
                        WashingMachine washingMachine = new WashingMachine(s, volume, price);
                        ProductRepository.saveProduct(washingMachine);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),washingMachine);
                        Stock stock10 = new Stock(washingMachine, units);
                        StockRepository.saveStock(stock10);
                        break;
                    case 12:
                        Fridge fridge = new Fridge(s, volume, price);
                        ProductRepository.saveProduct(fridge);
                        SupplierRepository.updateSupplier(s.getIdSupplier(),fridge);
                        Stock stock11 = new Stock(fridge, units);
                        StockRepository.saveStock(stock11);
                        break;
                
                    default:
                        break;
                    
                    
                }
                break;
                case 2:
                    System.out.println( "You have selected to remove a product" );
                    System.out.println( "Please enter the product's id" );
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    ProductRepository.deleteProduct(id);
                    System.out.println( "The product has been removed successfully!" );
                    break;
                case 3:
                    System.out.println( "You have selected to update a product" );
                    System.out.println( "Please enter the product's id" );
                    int id1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println( "Please enter what would you like to change" );
                    String change = scanner.nextLine();
                    System.out.println( "Please enter the new value" );
                    String newchange = scanner.nextLine();
                    try{
                        ProductRepository.updateProduct(id1, change,newchange);
                    }catch(IllegalAccessError e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("The product has been changed successfully!");
                    break;
                case 4:
                    System.out.println( "You have selected to view all products" );
                    System.out.println( "This is the List of products that are available at the moment:" );
                    System.out.println( ProductRepository.getAllProducts() );
                    break;
        }
    }

    public static void SupplierMenu(){
        System.out.println( "You are in the SUPPLIER'S MENU" );
        System.out.println( "What would you like to do?" );
        System.out.println( "1. Add a supplier" );
        System.out.println( "2. Remove a supplier" );
        System.out.println( "3. Update a supplier" );
        System.out.println( "4. View all suppliers" );
        System.out.println( "5. View a specific supplier" );
        int choice4 = scanner.nextInt();
        scanner.nextLine();
        switch (choice4) {
            case 1:
                System.out.println( "You have selected to add a supplier" );
                System.out.println( "Please enter the supplier's name" );
                String name = scanner.nextLine();
                System.out.println( "Please enter the supplier's address" );
                String address = scanner.nextLine();
                System.out.println( "Please enter the supplier's email" );
                String email = scanner.nextLine();
                System.out.println( "Please enter the supplier's phone number" );
                String phone = scanner.nextLine();
                Supplier supplier = new Supplier(SupplierRepository.nextIdSupplier(),name, address, email, phone);
                SupplierRepository.saveSupplier(supplier);
                break;
            case 2:
                System.out.println( "You have selected to remove a supplier" );
                System.out.println( "Please enter the supplier's name" );
                String nameSup = scanner.nextLine();
                SupplierRepository.deleteSupplier(SupplierRepository.getSupplierByName(nameSup).getIdSupplier());
                System.out.println( "The supplier has been removed successfully!" );
                break;
            case 3:
                System.out.println( "You have selected to update a supplier" );
                System.out.println( "Please enter the supplier's id" );
                int id1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( "Please enter what would you like to change" );
                String change = scanner.nextLine();
                System.out.println( "Please enter the new value" );
                String newchange = scanner.nextLine();
                try{
                    SupplierRepository.updateSupplier(id1, change,newchange);
                }catch(IllegalAccessError e){
                    System.out.println(e.getMessage());
                }
                System.out.println("The supplier has been changed successfully!");
                break;
            case 4:
                System.out.println( "You have selected to view all suppliers" );
                System.out.println( "This is the List of suppliers that are available at the moment:" );
                System.out.println( SupplierRepository.getAllSuppliers() );
                break;
            case 5:
                System.out.println( "You have selected to view a specific supplier" );
                System.out.println( "Please enter the supplier's name");
                String nameSupp = scanner.nextLine();
                System.out.println( SupplierRepository.getSupplierByName(nameSupp).display_supplier_info() );
                break;
            default:
                break;
        }
    }

    public static void TransportMenu(){
        System.out.println( "You are in the TRANSPORT'S MENU" );
        System.out.println( "What would you like to do?" );
        System.out.println( "1. Add a transport" );
        System.out.println( "2. Remove a transport" );
        System.out.println( "3. Update a transport" );
        System.out.println( "4. View all transports" );
        System.out.println( "5. View a specific transport" );
        int choice5 = scanner.nextInt();
        scanner.nextLine();
        switch (choice5) {
            case 1:                
                System.out.println( "You have selected to add a transport" );
                System.out.println("Please enter the transport's cost per km");
                int costPerKM = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter the transport's speed");
                double speed = scanner.nextDouble();
                System.out.println( "Please enter the transport's type" );
                System.out.println( "1. Truck" );
                System.out.println( "2. Ship" );
                System.out.println( "3. Plane" );
                int type = scanner.nextInt();
                scanner.nextLine();
                switch(type){
                    case 1:
                        TransportFactory truckFactory= new TruckFactory();
                        Transport truck = truckFactory.createTransport(TransportRepository.nextIdTransport(), costPerKM, speed);
                        TransportRepository.saveTransport(truck);
                        break;
                    case 2:
                        TransportFactory shipFactory= new ShipFactory();
                        Transport ship = shipFactory.createTransport(TransportRepository.nextIdTransport(), costPerKM, speed);
                        TransportRepository.saveTransport(ship);
                        break;
                    case 3:
                        TransportFactory planeFactory= new PlaneFactory();
                        Transport plane = planeFactory.createTransport(TransportRepository.nextIdTransport(), costPerKM, speed);
                        TransportRepository.saveTransport(plane);
                        break;
                    default:
                        break;
                }
                break;
                
            case 2:
                System.out.println( "You have selected to remove a transport" );
                System.out.println( "Please enter the transport's id" );
                int id = scanner.nextInt();
                scanner.nextLine();
                TransportRepository.deleteTransport(id);
                System.out.println( "The transport has been removed successfully!" );
                break;
            case 3:
                System.out.println( "You have selected to update a transport" );
                System.out.println( "Please enter the transport's id" );
                int id1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( "Please enter what would you like to change" );
                String change = scanner.nextLine();
                System.out.println( "Please enter the new value" );
                String newchange = scanner.nextLine();
                try{
                    SupplierRepository.updateSupplier(id1, change,newchange);
                }catch(IllegalAccessError e){
                    System.out.println(e.getMessage());
                }
                System.out.println("The transport has been changed successfully!");
                break;
            case 4:
                System.out.println( "You have selected to view all transports" );
                System.out.println( "This is the List of transports that are available at the moment:" );
                System.out.println( TransportRepository.getAllTransports() );
                break;
            case 5:
                System.out.println( "You have selected to view a specific transport" );
                System.out.println( "Please enter the transport's id" );
                int id2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( TransportRepository.getTransportById(id2) );
                break;
            default:
                break;
        }
    }

    public static void ShipmentMenu(){
        System.out.println( "You are in the SHIPMENT'S MENU" );
        System.out.println( "What would you like to do?" );
        System.out.println( "1. Add a shipment" );
        System.out.println( "2. Cancel a shipment" );
        System.out.println( "3. Update a shipment" );
        System.out.println( "4. View all shipments" );
        int choice6 = scanner.nextInt();
        scanner.nextLine();
        switch (choice6) {
            case 1:
                System.out.println( "You have selected to add a shipment" );
                System.out.println("Please enter the shipment's transport id");
                int transportId = scanner.nextInt();
                scanner.nextLine();
                Transport transport = TransportRepository.getTransportById(transportId);
                //the packaging volume will be based on the transport's type
                List<Packaging> packagingList = new ArrayList<Packaging>();
                System.out.println("Please enter the shipment's customer id");
                int customerId = scanner.nextInt();
                scanner.nextLine();
                Customer customer = CustomerRepository.getCustomerById(customerId);
                List<Product> products = new ArrayList<Product>();
                packagingList.add(new Packaging(transport));
                int i=0;
                do{
                    System.out.println("Please enter the id and the quantity of the products you want to add to the shipment");
                    int productid = scanner.nextInt();
                    scanner.nextLine();
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    Product product = ProductRepository.getProductById(productid);
                    if(quantity>StockRepository.getStockQuantity(product)){
                        System.out.println("The quantity you entered is bigger than the available stock of the product");
                    }
                    else{
                        products.add(product);
                        StockRepository.updateStock(product,StockRepository.getStockQuantity(product)-quantity);
                        if(StockRepository.getStockQuantity(product)==0){
                        ProductRepository.deleteProduct(product.getProductId());
                        StockRepository.deleteStock(product);
                        }
                        ProductRepository.updateProduct(product);
                        if(product.getVolume()*quantity<=packagingList.get(i).getCapacity()){
                            packagingList.get(i).addProduct(product);
                            packagingList.get(i).addToMap(product, quantity);
                        }
                        else{
                            packagingList.add(new Packaging(transport));
                            i++;
                            packagingList.get(i).addProduct(product);
                            packagingList.get(i).addToMap(product, quantity);
                        }
                    }
                System.out.println("Would you like to add more products? Please write yes");
                }while(scanner.nextLine().equals("yes"));
                Shipment shipment = new Shipment(ShipmentRepository.nextIdShipment(), customer, packagingList , transport, LocalDate.now());
                if(shipment.getCustomer().getName()=="mark"){
                    ShipmentDecorator shipmentCost = new ShipmentDecoratorTotalCost(shipment);
                    ShipmentRepository.saveShipment(shipmentCost);
                    System.out.println("The total cost of the shipment is: "+shipmentCost.getTotalCost());
                }
                else if(shipment.getCustomer().getName()=="john"){
                    ShipmentDecorator shipmentDelivery = new ShipmentDecoratorDeliveryDate(shipment);
                    ShipmentRepository.saveShipment(shipmentDelivery);
                    System.out.println("The delivery date of the shipment is: "+shipmentDelivery.getDeliveryDate());
                }
                else{
                    ShipmentRepository.saveShipment(shipment);
                }
                break;

            case 2:
                System.out.println("Please enter the shipment's id");
                ShipmentRepository.getAllShipments();
                int id = scanner.nextInt();
                scanner.nextLine();
                try{
                    ShipmentRepository.deleteShipment(id);
                }catch(IllegalAccessError e){
                    System.out.println(e.getMessage());
                }
                break;

            case 3: 
                System.out.println("Please enter the shipment's id");
                int id1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter what would you like to change");
                String change = scanner.nextLine();
                System.out.println("Please enter the new value");
                String newchange = scanner.nextLine();
                try{
                    ShipmentRepository.updateShipment(id1, change, newchange);
                }catch(IllegalAccessError e){
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println( "You have selected to view all shipments" );
                System.out.println( "This is the List of shipments that are available at the moment:" );
                System.out.println( ShipmentRepository.getAllShipments() );
                break;
        }
    }

    public static void StockMenu(){
        System.out.println("You have selected the Stock option");
        System.out.println("What would you like to do?");
        System.out.println("1. View all the stock");
        System.out.println("2. View a specific product's stock");
        System.out.println("3. Increase product stock");
        int choice7 = scanner.nextInt();
        scanner.nextLine();
        switch(choice7){
            case 1:
                System.out.println( "You have selected to view all the stock" );
                System.out.println( "This is the List of stock that is available at the moment:" );
                System.out.println( StockRepository.getAllStocks() );
                break;
            case 2:
                System.out.println( "You have selected to view a specific product's stock" );
                System.out.println( "Please enter the product's id" );
                int id = scanner.nextInt();
                scanner.nextLine();
                Stock s = StockRepository.getStockById(id);
                System.out.println( s.display_stock_info() );
                break;
            case 3:
                System.out.println( "You have selected to increase product stock" );
                System.out.println( "Please enter the product's id" );
                int id1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println( "Please enter the quantity you want to add" );
                int quantity = scanner.nextInt();
                scanner.nextLine();
                StockRepository.updateStock(ProductRepository.getProductById(id1),quantity);
                break;
            default:
                break;
        }
    }

    public static void main( String[] args )
    {        
        System.out.println( "Welcome to the Logistics Management Application OF THE UNIVERSITY OF MALTA" );
        System.out.println( "This is the main class" );
        do{
            index();
            int choice = 0;
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    do{
                        CustomerMenu();
                        System.out.println( "Would you like to do anything more with Customers? Please write yes" );
                    }while(scanner.nextLine().equals("yes"));
                    break;
                    
                case 2:
                    do{
                        SupplierMenu();
                        System.out.println( "Would you like to do anything more with Suppliers? Please write yes" );
                    }while(scanner.nextLine().equals("yes")); 
                    break;

                case 3: 
                    do{
                        TransportMenu();
                        System.out.println( "Would you like to do anything more with Transports? Please write yes" );
                    }while(scanner.nextLine().equals("yes"));
                    break;
            
                case 4:
                    do{
                        ProductMenu();
                        System.out.println( "Would you like to do anything more with Products? Please write yes" );
                    }while(scanner.nextLine().equals("yes"));
                    break;
        
                case 5:
                    do{ 
                        ShipmentMenu();
                        System.out.println( "Would you like to do anything more with Shipments? Please write yes" );
                    }while(scanner.nextLine().equals("yes"));
                    break;
                case 6: 
                    do{
                        StockMenu();
                        System.out.println( "Would you like to do anything more with Stock? Please write yes" );
                    }while(scanner.nextLine().equals("yes"));
                    break;
                    
                }
            
            System.out.println( "Would you like to do anything more with the application? Please write yes" );
        }while(scanner.nextLine().equals("yes"));
        scanner.close();
    }
}