//package Interfaces;
//
//import Models.Carrier;
package homework4.Interfaces;

import homework4.Models.Carrier;

/**
 * Интерфейс взаимодействия с базой перевозчиков
 */
public interface ICarrierRepo {
    /**
     * Получить модель перевозчика из базы по ID
     *
     * @param id идентификатор перевозчика в базе
     * @return перевозчика
     */
    Carrier read(int id);
}
