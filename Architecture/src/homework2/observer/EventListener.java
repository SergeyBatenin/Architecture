package homework2.observer;

/**
 * общий маркер наших подписчиков(слушателей) которые ждут сигнала
 */
public interface EventListener {
    void update(String eventType);
}
