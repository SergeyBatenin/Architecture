package homework2.singletone;

public class Main {
    public static void main(String[] args) {
        Singletone s1 = Singletone.getInstance();
        Singletone s2 = Singletone.getInstance();
        // если все работает то на оба объекта должна быть одна и та же ссылка
        System.out.println(s1 == s2); // true
    }
}
