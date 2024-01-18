package project.shipment;

import java.util.ArrayList;
import java.util.List;

public class ShipmentRepository {
    private static List<ShipmentComponent> repository=new ArrayList<ShipmentComponent>();
    private static int nextIdShipment;

    public ShipmentRepository() {
        repository = new ArrayList<>();
        nextIdShipment = 0;
    }

    public static int nextIdShipment() {
        return nextIdShipment++;
    }

    public static void saveShipment(ShipmentComponent shipment) {
        repository.add(shipment);
    }

    public static void updateShipment(int id, String change, String newchange) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Shipment not found");
        }
        ShipmentComponent shipment = repository.get(id);
        shipment.updateShipment(change, newchange);
    }

    public static ShipmentComponent getShipmentById(int id) {
        return repository.get(id);
    }

    public static String getAllShipments() {
        String result="";
        for (ShipmentComponent shipment : repository) {
            result += shipment.toString()+"\n";
        }
        return result;
    }

    public static void deleteShipment(int id) {
        if(!repository.contains(repository.get(id))){
            throw new IllegalAccessError("Shipment not found");
        }
        repository.remove(id);
    }
}
