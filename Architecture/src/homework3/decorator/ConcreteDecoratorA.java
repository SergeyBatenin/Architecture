package homework3.decorator;

public class ConcreteDecoratorA extends Decorator{
    private Object addedState;

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
    }
}
