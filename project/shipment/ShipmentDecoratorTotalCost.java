package project.shipment;

public class ShipmentDecoratorTotalCost extends ShipmentDecorator {
    public ShipmentDecoratorTotalCost(Shipment wrapee) {
        super(wrapee);
    }

    @Override
    public double getTotalCost() {
        return super.getTotalCost() * 0.16;
    }

    public String toString() {
        return "Shipment{ "+ getIdShipment() + " " + getCustomer().toString() +
        ", " + getPackagings().toString() + ", " + getTransport().toString() + ", " + 
        getPurchaseDate() + ", " + getDeliveryDate()+"€}";
    }
}