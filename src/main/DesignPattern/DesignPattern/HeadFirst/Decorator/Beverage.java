package DesignPattern.HeadFirst.Decorator;

/** this is a abstract component class**/
public abstract class Beverage {
    protected static final int TALL = 1;
    protected static final int GRANDE = 2;
    protected static final int VENTI= 3;
    String description;
    int size;

    public String getDescription() { // description with depends on the sub class
        return description;
    }

    public int getSize(){
        return size;
    };

    public void setSize(int size){
        this.size = size;
    }

    public abstract double cost(); // detailed implementation will be achieved in sub classes
}

