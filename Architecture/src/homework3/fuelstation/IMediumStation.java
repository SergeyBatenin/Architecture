package homework3.fuelstation;

import homework3.cars.Car;

/**
 * возможности заправки среднего размера
 */
public interface IMediumStation extends ISimpleStation{
    /**
     * метод протирания зеркал
     */
    void wipeMirrors(Car car);
}
