package homework2.observer;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // создаем нашего "издателя" за которым будем наблюдать
        Publisher eksmo = new Publisher("Философия java", "Паттерны проектирования", "Чистый код");

        // добавляем подписчиков, которые хотят получить в определенное время оповещение
        eksmo.eventManager.subscribe("Философия java", new EmailNotification("hochuKnigu@java.ru"));
        eksmo.eventManager.subscribe("Паттерны проектирования", new SMSNotification("+7 123 5678900"));
        eksmo.eventManager.subscribe("Чистый код", new SMSNotification("+7 234 5678901"));
        eksmo.eventManager.subscribe("Чистый код", new EmailNotification("cleanCode@proger.com"));

        // вызываем событие, на которое должен сработать наш наблюдатель и оповестить нужные объекты
        eksmo.deliveryGoods(Map.of(
                "Философия java", 5,
                "Паттерны проектирования", 3,
                "Чистый код", 1
        ));
    }
}
