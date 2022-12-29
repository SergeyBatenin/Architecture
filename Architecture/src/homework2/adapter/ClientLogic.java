package homework2.adapter;

// какой то клиентский класс
public class ClientLogic {

    // поля
    //конструкторы

    public void getInfoFromData(JSONData data) {
        // Метод получения необходимых данных из "нового" класса JSONData
        System.out.println(data.getInfo());
    }
}
