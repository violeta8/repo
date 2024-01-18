package project.shipment;

import java.time.LocalDate;

public class ShipmentDecoratorDeliveryDate extends ShipmentDecorator{
    public ShipmentDecoratorDeliveryDate(Shipment wrapee) {
        super(wrapee);
    }

    @Override
    public LocalDate getDeliveryDate() {
        return super.getDeliveryDate().plusDays(2);     
    }

    
    public String toString() {
        return "Shipment{ "+ getIdShipment() + " " + getCustomer().toString() +
        ", " + getPackagings().toString() + ", " + getTransport().toString() + ", " + 
        getPurchaseDate() + ", " + getDeliveryDate()+"€}";
    }
}