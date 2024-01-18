package project.transport;

public abstract class Transport {
    private int idTransport;
    private int costPerKM;
    private double speed;

    public abstract int route();//this will be added in the subclasses

    public Transport(int idTransport, int costPerKM, double speed) {
        this.idTransport = idTransport;
        this.costPerKM = costPerKM;
        this.speed = speed;
    }
    

    public void updateTransport(int id,String change,String newchange){
        if(change.equals("costPerKM")) {
            this.setCostPerKM(Integer.parseInt(newchange));
        }
        if(change.equals("speed")) {
            this.setSpeed(Double.parseDouble(newchange));
        }
    }

    public int getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    public int getCostPerKM() {
        return costPerKM;
    }

    public void setCostPerKM(int costPerKM) {
        this.costPerKM = costPerKM;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    @Override
    public String toString() {
        return "idTransport=" + idTransport + " costPerKM=" + costPerKM +  ", speed=" + speed + "]";
    }
}
