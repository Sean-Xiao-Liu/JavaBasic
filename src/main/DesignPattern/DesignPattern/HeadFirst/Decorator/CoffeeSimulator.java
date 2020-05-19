package DesignPattern.HeadFirst.Decorator;

public class CoffeeSimulator {

    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $ "+ espresso.cost());

        /** put different layer of decorators on the beverage**/
        espresso = new Mocha(espresso);
        espresso = new Soy(espresso);
        System.out.println(espresso.getDescription() + " $ "+ espresso.cost());
    }
}
