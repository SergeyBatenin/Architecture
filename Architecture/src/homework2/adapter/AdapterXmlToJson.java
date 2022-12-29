package homework2.adapter;

public class AdapterXmlToJson extends JSONData {

    private XMLData data;

    public AdapterXmlToJson(XMLData data) {
        this.data = data;
    }

    /**
     * Переопределяем метод родительского класса,
     * чтобы мы могли получать нужную информацию
     * из объектов "старого" типа
     * @return
     */
    @Override
    public String getInfo() {
        return data.getInfoFromXML();
    }
}
