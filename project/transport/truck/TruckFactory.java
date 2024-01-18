package project.transport.truck;
import project.transport.*;

public class TruckFactory implements TransportFactory{
    public Transport createTransport(int idTransport, int costPerKM, double speed) {
        return new Truck(idTransport, costPerKM, speed);
    }
}
