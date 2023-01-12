//package Interfaces;
package homework4.Interfaces;

import homework4.Models.BankAccount;

import java.util.List;

/**
 * Интерфейс взаимодействия с базой банковских операций
 */
public interface ICashRepo {
    /**
     * Метод проведения транзакции
     *
     * @param payment  платеж
     * @param cardFrom карта покупателя
     * @param cardTo   карта продавца
     * @return результат выполнения операции
     */
    boolean transaction(int payment, long cardFrom, long cardTo);

    List<BankAccount> getClients();
}
