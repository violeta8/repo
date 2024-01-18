package project.transport.ship;
import project.transport.*;

public class ShipFactory implements TransportFactory{
    public Transport createTransport(int idTransport, int costPerKM, double speed) {
        return new Ship(idTransport, costPerKM, speed);
    }
}
