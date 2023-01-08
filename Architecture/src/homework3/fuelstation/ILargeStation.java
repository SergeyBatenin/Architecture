package homework3.fuelstation;

import homework3.cars.Car;

/**
 * возможности заправки большого размера
 */
public interface ILargeStation extends IMediumStation{
    /**
     * метод протирания лобового стекла
     * @param car
     */
    void wipeWindScreen(Car car);

    /**
     * метод протирания фар
     * @param car
     */
    void wipeLights(Car car);
}
