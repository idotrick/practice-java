package main.java.pattern;

import java.util.logging.Logger;

interface IComponent {
    void operation();
}

class ConcreteComponent implements IComponent {
    @Override
    public void operation() {
        Logger.getGlobal().info(ConcreteComponent.class.getName()+": operation()");
    }
}

class Decorator implements IComponent {
    private IComponent component;

    Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        this.component.operation();
    }

}

class ConcreteDecorator extends Decorator {

    ConcreteDecorator(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        preOperation();
        super.operation();
        postOperation();
    }

    void preOperation() {
        Logger.getGlobal().info(ConcreteDecorator.class.getName()+": preOperation");
    }


    void postOperation() {
        Logger.getGlobal().info(ConcreteDecorator.class.getName()+": postOperation");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        IComponent concreteComponent = new ConcreteComponent();
        IComponent decoratedConcreteComponent = new ConcreteDecorator(concreteComponent);
        decoratedConcreteComponent.operation();
    }
}
