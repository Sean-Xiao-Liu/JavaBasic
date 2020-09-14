package DesignPattern.HeadFirst.Factory;

public class HawaiianPizza extends Pizza{
    public HawaiianPizza() {
        this.setName("hawaiian pizza");
        this.setSauce("pineapple sauce");
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
