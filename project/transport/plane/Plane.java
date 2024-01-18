package project.transport.plane;

import project.transport.Transport;

public class Plane extends Transport {

    public Plane(int idTransport, int costPerKM, double speed) {
        super(idTransport, costPerKM, speed);
    }

    protected Plane() {
        super(0, 0, 0);
    }

    @Override
    public int route() {
        return 256;
    }

    @Override
    public String toString() {
        return "Plane [" + super.toString() + "]";
    }
}
