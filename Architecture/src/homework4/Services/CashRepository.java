//package Services;
//
//import Interfaces.ICashRepo;
//import Models.BankAccount;
package homework4.Services;

import homework4.Interfaces.ICashRepo;
import homework4.Models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных банка
 */
public class CashRepository implements ICashRepo {
    private static CashRepository cashRepository;

    private List<BankAccount> clients;

    public List<BankAccount> getClients() {
        return clients;
    }

    private CashRepository() {
        //имитация работы банка
        clients = new ArrayList<>();
//        for (int i = 1; i <= 5; i++) {
//            clients.add(new BankAccount((long) (i * 1000000000 * Math.PI)));
//        }
        // из имитационной базы данных пользователей добавим банковские аккаунты
        clients.add(new BankAccount(1111));
        clients.add(new BankAccount(2222));
        clients.add(new BankAccount(3333));
        clients.add(new BankAccount(4444));
        // из имитационной базы перевозчиков добавим банковские аккаунты
        clients.add(new BankAccount(1));
        clients.add(new BankAccount(2));
    }

    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    /**
     * Метод осуществления транзакции по приобретению билета
     * @param payment  платеж
     * @param clientCard карта покупателя
     * @param carrierCard   карта продавца
     * @return
     * @throws RuntimeException
     */
    @Override
    public boolean transaction(int payment, long clientCard, long carrierCard) throws RuntimeException {
        // Проводим валидацию аккаунтов
        BankAccount passenger = null;
        BankAccount carrier = null;
        for (var client : clients) {
            if (client.getCard() == clientCard) {
                passenger = client;
            }
            if (client.getCard() == carrierCard) {
                carrier = client;
            }
        }
        // Проверяем наличие банковских карт продавца и покупателя
        if (passenger == null) {
            throw new RuntimeException("No money  client account.");
        }
        if (carrier == null) {
            throw new RuntimeException("No money carrier account.");
        }
        // Проверяем баланс средств на картах
        if (passenger.getBalance() < payment) {
            throw new RuntimeException("Insufficient funds.");
        }
        if (carrier.getBalance() > Integer.MAX_VALUE - payment) {
            throw new RuntimeException("Too much amount.");
        }
        // Блок finally выполнится в любом случае, даже если произойдет исключение.
        // Помещая операции по переводу денег в блок finally, мы создаем дополнительную безопасность
        // проведения транзакции.
        try {
        } finally {
            clients.remove(passenger);
            clients.remove(carrier);
            passenger.setBalance(passenger.getBalance() - payment);
            carrier.setBalance(carrier.getBalance() + payment);
            clients.add(passenger);
            clients.add(carrier);
        }
        return true;
    }
}
