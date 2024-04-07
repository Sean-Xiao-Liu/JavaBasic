package DesignPattern.HeadFirst.Decorator;

public abstract class Coffee {

    String description;
    Size size;

    public String getDescription() { // description with depends on the sub class
        return description;
    }

    public Size getSize(){
        return size;
    };

    public void setSize(Size size){
        this.size = size;
    }

    public abstract double cost();

    public abstract void setDescription();

    public enum Size{
        GRANDE,TALL,VENTI
    }

    public double getCostBySize(Size size){
        if (size.equals(Size.TALL)){
            return  1.0;
        } else if (size.equals(Size.GRANDE)){
            return  2.0;
        }
        return 3.0;
    }
}
