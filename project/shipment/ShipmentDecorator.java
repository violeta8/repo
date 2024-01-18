package project.shipment;
import java.time.LocalDate;
import java.util.List;

import project.customer.Customer;
import project.packaging.Packaging;
import project.transport.Transport;


public abstract class ShipmentDecorator implements ShipmentComponent{
    private Shipment wrapee;

    ShipmentDecorator(Shipment wrapee) {
        this.wrapee = wrapee;
    }

    public double getTotalCost() {
        return wrapee.getTotalCost();
    }

    public LocalDate getDeliveryDate() {
        return wrapee.getDeliveryDate();
    }

    public void updateShipment(String change, String newchange) {
        updateShipment(change, newchange);
    }

    public int getIdShipment() {
        return getIdShipment();
    }

    public void setIdShipment(int idShipment) {
        setIdShipment(idShipment);
    }

    public boolean equals(Shipment shipment) {
        return equals(shipment);
    }

    public Customer getCustomer() {
        return getCustomer();
    }

    public void setCustomer(Customer customer) {
        setCustomer(customer);
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        setDeliveryDate(deliveryDate);
    }

    public LocalDate getPurchaseDate() {
        return getPurchaseDate();
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        setPurchaseDate(purchaseDate);
    }

    public Transport getTransport() {
        return getTransport();
    }

    public void setTransport(Transport transport) {
        setTransport(transport);
    }

    public List<Packaging> getPackagings() {
        return getPackagings();
    }

    public void setPackagings(List<Packaging> packagings) {
        setPackagings(packagings);
    }

    public abstract String toString();
}