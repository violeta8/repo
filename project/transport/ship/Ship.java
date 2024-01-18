package project.transport.ship;

import project.transport.Transport;

public class Ship extends Transport{

    public Ship(int idTransport, int costPerKM, double speed) {
        super(idTransport, costPerKM, speed);
    }

    @Override
    public int route() {
        return 128;
    }
    
    @Override
    public String toString() {
        return "Ship [" + super.toString() + "]";
    }
}
