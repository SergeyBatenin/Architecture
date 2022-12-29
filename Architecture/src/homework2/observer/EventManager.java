package homework2.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * базовый класс издателя
 */
public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String ... eventTypes) {
        for (String eventType : eventTypes) {
            listeners.put(eventType, new ArrayList<>());
        }
    }

    /**
     * добавляем наблюдение за каким то событием и способ оповещения
     * @param eventType
     * @param listener
     */
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * удаляем наблюдение за каким то событием
     * @param eventType
     * @param listener
     */
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * совершаем оповещение о конкретном событии
     * @param eventType
     */
    public void notify(String eventType) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType);
        }
    }
}
