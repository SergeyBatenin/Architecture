package homework2.observer;

/**
 * класс слушатель, чтобы отправлять оповещение посредством электронной почты
 */
public class EmailNotification implements EventListener{

    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    /**
     * метод оповещения по электронной почте
     * @param eventType
     */
    @Override
    public void update(String eventType) {
        System.out.println("Было послано оповещение на электронную почту: " + email
                        + ", что в продажу поступила книга : " + eventType);
    }
}
