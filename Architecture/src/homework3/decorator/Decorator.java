package homework3.decorator;

public abstract class Decorator extends Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation(){
        component.operation();
    }
}
