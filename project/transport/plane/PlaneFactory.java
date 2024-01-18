package project.transport.plane;
import project.transport.*;

public class PlaneFactory implements TransportFactory{
    public Transport createTransport(int idTransport, int costPerKM, double speed) {
        return new Plane(idTransport, costPerKM, speed);
    }
}
