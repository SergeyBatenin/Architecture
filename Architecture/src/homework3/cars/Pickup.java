package homework3.cars;

public class Pickup extends Car {

    private double capacity; // грузоподъемность автомобиля

    /**
     * Перевозка груза
     */
    public void carryCargo() {
    }

    /**
     * Включение противотуманных фар
     *
     * @return
     */
    public boolean switchFogLights() {
        return true;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
