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
import homework4.Models.BankAccount;
import homework4.Models.Carrier;
import homework4.Models.Ticket;
import homework4.Models.User;
import homework4.Services.CarrierRepository;
import homework4.Services.CashRepository;

import java.util.List;

/**
 * Класс - провайдер для взаимодействия с банком и базой перевозчиков
 */
public class CashProvider {
    private final ICarrierRepo carrierRepository; // база перевозчиков
    private final ICashRepo cashRepository; // база
    private long clientCardNumber;
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
    public boolean buy(Ticket ticket) {
        Carrier carrier = carrierRepository.read(ticket.getRouteNumber());
        long carrierCard = carrier.getCardNumber();
        boolean transactionSuccess = cashRepository.transaction(ticket.getPrice(), clientCardNumber, carrierCard);
        return transactionSuccess;
    }

    /**
     * Метод авторизации клиента. Здесь должно быть реализовано обращение к банку для подтверждения личности клиента.
     *
     * @param client
     */
    public void authorization(User client) {
    // заглушка
        List<BankAccount> clients = cashRepository.getClients();
        for (BankAccount bankAccount : clients) {
            if (client.getCardNumber() == bankAccount.getCard()) {
                clientCardNumber = bankAccount.getCard();
                isAuthorized = true;
                return;
            }
        }
        throw new RuntimeException("BankAccount was not found");
    }


}
