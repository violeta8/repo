package project.transport.truck;

import project.transport.Transport;
public class Truck extends Transport{

    public Truck(int idTransport, int costPerKM, double speed) {
        super(idTransport, costPerKM, speed);
    }

    protected Truck() {
        super(0, 0, 0);
    }

    @Override
    public int route() {
        return 64;
    }

    @Override
    public String toString() {
        return "Truck [" +  super.toString()+ "]";
    }
}
