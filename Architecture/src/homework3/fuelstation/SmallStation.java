package homework3.fuelstation;

import homework3.cars.Car;

public class SmallStation implements ISimpleStation {
    @Override
    public void refillingCar(Car car) {
        car.refilling();
    }
}
