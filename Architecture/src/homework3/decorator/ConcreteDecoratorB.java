package homework3.decorator;

public class ConcreteDecoratorB extends Decorator{
    private Object addedState;

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }
    public void addedBehavior() {
    }
}
