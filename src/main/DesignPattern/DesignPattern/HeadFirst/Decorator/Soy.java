package DesignPattern.HeadFirst.Decorator;

import javax.swing.plaf.IconUIResource;

/** this is a concrete decorator, which extends CondimentDecorator, which extends Beverage**/
public class Soy extends CondimentDecorator {
    Beverage beverage;
    String sizeName;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy " + sizeName;
    }

    public int getSize(){
        return beverage.getSize();
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if(getSize() == Beverage.TALL){
            cost += 0.1;
            sizeName = "Tall";
        } else if(getSize() == Beverage.GRANDE){
            cost += 0.15;
            sizeName = "Grande";
        } else if(getSize() == Beverage.VENTI){
            cost += 0.2;
            sizeName = "Venti";
        }
        return cost + 0.15;
    }
}
