//package Core;
//
//import Interfaces.ICarrierRepo;
//import Interfaces.ICashRepo;
//import Models.Carrier;
//import Models.Ticket;
//import Models.User;
//import Services.CarrierRepository;
//import Services.CashRepository;
package homework4.Core;

import homework4.Interfaces.ICarrierRepo;
import homework4.Interfaces.ICashRepo;
import homework4.Models.Ticket;
import homework4.Models.User;
import homework4.Services.CarrierRepository;
import homework4.Services.CashRepository;

/**
 * Класс - провайдер для взаимодействия с банком и базой перевозчиков
 */
public class CashProvider {
    private final ICarrierRepo carrierRepository; // база перевозчиков
    private final ICashRepo cashRepository; // база
    private long cardNumber;
    private boolean isAuthorized;

    /**
     * Конструктор класса
     */
    public CashProvider() {
        // Класс репозитория находится в единственном экземпляре для того, чтобы не создавать несколько подключений
        // к базе данных. Реализация паттерна Синглтон.
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Метод покупки билета
     *
     * @param ticket билет
     * @return результат выполнения операции
     * @throws RuntimeException
     */
    // подсказка  Carrier carrier = carrierRepository.read(1);
    // подсказка  return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
    public boolean buy(Ticket ticket) {
        return false;//заглушка
    }

    /**
     * Метод авторизации клиента. Здесь должно быть реализовано обращение к банку для подтверждения личности клиента.
     *
     * @param client
     */
    public void authorization(User client) {
    // заглушка
    }


}
