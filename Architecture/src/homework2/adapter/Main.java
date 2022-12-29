package homework2.adapter;

public class Main {
    public static void main(String[] args) {
        ClientLogic clientLogic = new ClientLogic();
        JSONData json = new JSONData();

        // пытаемся получить данных из "нового" формата
        clientLogic.getInfoFromData(json); // output -> "json"

        XMLData xml = new XMLData();
        // пробуем получить данные из "старого" типа
        // clientLogic.getInfoFromData(xml); Не сработает, будет ошибка компиляции

        // Пробуем создать наш адаптер и передать в него наш xml
        // и получить данные через него
        AdapterXmlToJson adapter = new AdapterXmlToJson(xml);
        clientLogic.getInfoFromData(adapter); // Все работает, output - > "xml"
    }
}
