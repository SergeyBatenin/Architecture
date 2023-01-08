package homework3.facade;

public class Facade {
    public void commonMethod(Object obj) {
        if (obj instanceof Class1) {
            ((Class1)( obj)).method();
        } else if (obj instanceof Class2) {
            ((Class2)( obj)).method();
        } else if (obj instanceof Class3) {
            ((Class3)( obj)).method();
        }
    }
}
