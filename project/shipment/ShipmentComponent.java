package project.shipment;
import java.time.LocalDate;
import java.util.List;
import project.customer.Customer;
import project.packaging.Packaging;
import project.transport.Transport;


public interface ShipmentComponent {
    public double getTotalCost();
    public LocalDate getDeliveryDate();
    public void updateShipment(String change, String newchange);
    public int getIdShipment();
    public void setIdShipment(int idShipment);
    public boolean equals(Shipment shipment);
    public Customer getCustomer();
    public void setCustomer(Customer customer);
    public void setDeliveryDate(LocalDate deliveryDate);
    public List<Packaging> getPackagings();
    public void setPackagings(List<Packaging> packagings);
    public Transport getTransport();
    public void setTransport(Transport transport);
    public LocalDate getPurchaseDate();
    public void setPurchaseDate(LocalDate purchaseDate);
    public String toString();
}
