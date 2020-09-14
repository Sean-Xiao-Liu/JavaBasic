package DesignPattern.HeadFirst.Factory;

/** Seperated from the PizzaStore class,
 * this factory is open to change and is used to return pizza instance**/
public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type == "hawaii") {
            pizza = new HawaiianPizza();
        } else if(type == "cheese"){
            pizza = new CheesePizza();
        }

        return pizza;
    }


}
