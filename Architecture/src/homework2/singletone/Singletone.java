package homework2.singletone;

public class Singletone {
    private static Singletone instance; // наш единственный экземпляр

    private Singletone() {
    }

    public static Singletone getInstance() {
        // если это первое наше обращение к данному классу, то мы его инициализируем
        if (instance == null) {
            instance = new Singletone();
        }

        return instance;
    }
}
