//package Services;
//
//import Interfaces.ICarrierRepo;
//import Models.Carrier;
package homework4.Services;

import homework4.Interfaces.ICarrierRepo;
import homework4.Models.Carrier;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных перевозчиков
 */
public class CarrierRepository implements ICarrierRepo {
    private static CarrierRepository carrierRepository;
    private List<Carrier> carriers;

    private CarrierRepository() {
        // Заполняем базу данных
        carriers = new ArrayList<>();
        carriers.add(new Carrier(1, 123456));
        carriers.add(new Carrier(2, 234567));

    }

    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    /**
     * Метод поиска перевозчика по его id
     * @param id идентификатор перевозчика в базе
     * @return  найденного перевозчика
     * @throws RuntimeException если перевозчик не найден
     */
    @Override
    public Carrier read(int id) throws RuntimeException {
        for (var carrier : carriers) {
            if (carrier.getId() == id) {
                return carrier;
            }
        }
        throw new RuntimeException("A carrier with this ID not found");
    }
}
