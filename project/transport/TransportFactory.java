package project.transport;

public interface TransportFactory {
    public Transport createTransport(int idTransport, int costPerKM, double speed);
}
