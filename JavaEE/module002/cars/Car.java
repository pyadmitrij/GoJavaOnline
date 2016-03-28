package module002.cars;

public class Car {

    protected String name;
    protected Transmission transmissionType;
    protected int maxSpeedKmh;

    public Transmission getTransmissionType() {
        return transmissionType;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", transmissionType=" + transmissionType +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }

    public void setMaxSpeedKmh(int maxSpeedKmh) {
        this.maxSpeedKmh = maxSpeedKmh;
    }
}
