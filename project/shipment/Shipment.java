package project.shipment;

import project.customer.Customer;
import project.packaging.Packaging;
import project.transport.Transport;
import project.transport.TransportRepository;

import java.util.List;
import java.time.LocalDate;

public class Shipment implements ShipmentComponent{
    private int idShipment;
    private Customer customer;
    private List<Packaging> packagings;//this should already have the whole products inside of it
    private Transport transport;
    private LocalDate purchaseDate;
    private LocalDate deliveryDate;

    public Shipment(int idShipment, Customer customer, List<Packaging> packagings, Transport transport, LocalDate purchaseDate) {
        this.idShipment = idShipment;
        this.customer = customer;
        this.packagings = packagings;
        this.transport = transport;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = getDeliveryDate();
    }

    public Shipment( Customer customer, List<Packaging> packagings, Transport transport, LocalDate purchaseDate) {
        this.customer = customer;
        this.packagings = packagings;
        this.transport = transport;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = getDeliveryDate();
    }

    public Shipment() {
        this.idShipment = 0;
        this.customer = null;
        this.packagings = null;
        this.transport = null;
        this.purchaseDate = null;
        this.deliveryDate = null;
    }

    public boolean equals(Shipment shipment) {
        return this.idShipment == shipment.idShipment;
    }

    public void updateShipment(String change, String newchange)
    {
        if(change.equals("transport")) {
            this.setTransport(TransportRepository.getTransportById(Integer.parseInt(newchange)));
        }
        else if(change.equals("delivery date")) {
            this.setDeliveryDate(LocalDate.parse(newchange));
        }
        else {
            throw new IllegalArgumentException("There's no right change");
        }
    }

    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Packaging> getPackagings() {
        return packagings;
    }

    public void setPackagings(List<Packaging> packagings) {
        this.packagings = packagings;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public double getTotalCost() {
        double total=0;
        for(Packaging packaging:packagings){
            total+=packaging.getTotalCost()+(((transport.route()+customer.getWarehouseDistance())*transport.getCostPerKM()) /transport.getSpeed());
        }
        return total;
        
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate() {
        this.purchaseDate = LocalDate.now();
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDeliveryDate() {//there cannot be a wrong deliverydate as it is calculated from the purchase date
        int distance = (int)(customer.getWarehouseDistance()/100);
        LocalDate aux;
        if(transport.route()==64){
            aux = purchaseDate.plusDays(1+distance);
        }
        else if(transport.route()==128){
            aux = purchaseDate.plusDays(4+distance);
        }
        else {
            aux = purchaseDate.plusDays(8+distance);
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "idShipment=" + idShipment +
                ", customer=" + customer.toString() +
                ", packagings=" + packagings.toString() +    
                ", transport=" + transport.toString() +
                ", purchaseDate=" + purchaseDate +
                ", deliveryDate=" + deliveryDate +
                ", totalCost=" + getTotalCost() + "€" +
                '}' + "\n";
    }

}
