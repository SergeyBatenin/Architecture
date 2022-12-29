package homework2.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * класс конкретного издателя в котором могут происходить действия, за которым установлено наблюдение
 * в данном случае условный книжный магазин
 */
public class Publisher {

    public EventManager eventManager; // наблюдатель
    private Map<String, Integer> books; // список наших книг на складе и их количество

    /**
     * конструктор
     * @param eventTypes
     */
    public Publisher(String ... eventTypes) {
        this.eventManager = new EventManager(eventTypes);
        books = new HashMap<>();
    }

    /**
     * доставка товара в наш магазин
     * @param deliveryBooks
     */
    public void deliveryGoods(Map<String, Integer> deliveryBooks) {

        for (String bookName : deliveryBooks.keySet()) {
            books.putIfAbsent(bookName, 0);
            books.put(bookName, books.get(bookName) + deliveryBooks.get(bookName));
            eventManager.notify(bookName);
        }
    }
}
