package DesignPattern.HeadFirst.Decorator;

public class American extends Coffee{
    Coffee coffee;
    Size size;

    public American(Coffee coffee,Size size){
        this.coffee = coffee;
        this.size  =size;
    }

    @Override
    public double cost() {
        return coffee.getCostBySize(size)+1.0;
    }

    @Override
    public void setDescription() {
        this.description = "American coffee";
    }
}
