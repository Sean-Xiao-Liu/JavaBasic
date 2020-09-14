package DesignPattern.HeadFirst.Factory;

public class PizzaStore extends AbstractPizzaStore{

    SimplePizzaFactory factory;

    /*
        use constructor to initialize the factory
     */
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    /*
        use factory to create pizza
     */

    @Override
    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        return pizza;
    }
}
