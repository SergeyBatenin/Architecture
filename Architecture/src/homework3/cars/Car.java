package homework3.cars;

import java.awt.*;

/**
 * базовый класс авто с общими полями
 */
public abstract class Car {
    private String manufacturer; // Марка авто
    private String model;   // Модель авто
    private Color color;    // Цвет авто
    private BodyType bodyType;  // Тип кузова
    private int numberWheels;   // Количество колес
    private FuelType fuelType;  // Тип топлива
    private TransmissionType transmissionType;  // Тип трансмиссии
    private double engineVolume;    // Объем двигателя

    /**
     * метод движения
     */
    public void move() {
    }

    /**
     * метод обслуживания авто
     */
    public void service() {
    }

    /**
     * метод переклчюения передач
     *
     * @return
     */
    public boolean gearShifting() {
        return true;
    }

    /**
     * метод включения фар
     *
     * @return
     */
    public boolean switchHeaderLights() {
        return true;
    }

    /**
     * метод включения дворников
     *
     * @return
     */
    public boolean switchWipers() {
        return true;
    }

    /**
     * метод заправки
     */
    public void refilling() {
    }

    /**
     * getters, setters
     *
     * @return
     */
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getNumberWheels() {
        return numberWheels;
    }

    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
}
