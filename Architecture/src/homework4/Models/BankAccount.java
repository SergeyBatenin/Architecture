//package Models;
package homework4.Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {
    private long card;
    private long oldCard;
    private int balance;

    public BankAccount(long cardNumber) {
        this.card = cardNumber;
        this.oldCard = this.card;
        this.balance = 1000;
    }

    /**
     * Метод замены банковской карты
     * @param newCardNumber устанавливает текущую банковскую карту
     */
    public void updateCard(long newCardNumber) {
        oldCard = card;
        card = newCardNumber;
    }

    public long getCard() {
        return this.card;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}
