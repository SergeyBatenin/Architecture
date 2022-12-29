package homework2.observer;

/**
 * класс слушатель для оповещений по смс-сообщениям
 */
public class SMSNotification implements EventListener{

    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * метод оповещения по смс
     * @param eventType
     */
    @Override
    public void update(String eventType) {
        System.out.println("Было послано смс-сообщение на номер: " + phoneNumber
                         + ", что в продажу поступила книга : " + eventType);
    }
}
