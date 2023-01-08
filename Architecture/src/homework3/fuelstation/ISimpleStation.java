package homework3.fuelstation;

import homework3.cars.Car;

/**
 * возможности заправки небольшого размера
 */
public interface ISimpleStation {
    /**
     * метод заправки машины
     */
    void refillingCar(Car car);
}
