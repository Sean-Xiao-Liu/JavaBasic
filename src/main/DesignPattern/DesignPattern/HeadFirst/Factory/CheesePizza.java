package DesignPattern.HeadFirst.Factory;

public class CheesePizza extends Pizza {

    public CheesePizza() {
        this.setName("cheese pizza");
        this.setSauce("triple cheese");
    }


    @Override
    void bake() {
        System.out.println("bake "+ getName() + " and "+ getSauce() +" for 20 min");
    }

    @Override
    void cut() {
        System.out.println("cut " + getName() + " into 8 pieces");
    }

    @Override
    void box() {
        System.out.println("put " + getName() + " into box");
    }

}
