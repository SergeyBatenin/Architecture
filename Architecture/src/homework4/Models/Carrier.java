//package Models;
package homework4.Models;

/**
 * Модель перевозчика
 */
public class Carrier {
    private int id; // id перевозчика из базы
    private long cardNumber;

    public Carrier(int id, long cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }
    public int getId() {
        return this.id;
    }

    public long getCardNumber() {
        return cardNumber;
    }
}
