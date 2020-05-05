package DesignPattern.HeadFirst.Stratey;

/** another solution is to break method into interfaces and let subclass implements these interfaces
 * the problem is, when the number of subclass increased, you need to take care each one of them and there will
 * be a lot of duplicated codes**/
public class DuckVersionTwo {
    public void swim(){

    }
    public void display(){
    }
}

interface Quackable{
    void quack();
}

interface Flyable{
    void fly(); /** ducks may also have different fly behaviors**/
}

/** isolate the parts that might be changed frequently from the stable ones**/
class RubberDuckTwo extends DuckVersionTwo implements Quackable,Flyable{

    @Override
    public void quack() {

    }

    @Override
    public void fly() {

    }
}