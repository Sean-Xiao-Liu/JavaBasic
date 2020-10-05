package DesignPattern.HeadFirst.Adapter;

public class DuckSimulatorTwo extends TurkeyDuckAdapter{

    public DuckSimulatorTwo(Turkey turkey) {
        super(turkey);
    }

    public static void main(String[] args) {

        Turkey turkey = new SomeTurkey();

        DuckSimulatorTwo duckSimulatorTwo = new DuckSimulatorTwo(turkey);
        duckSimulatorTwo.fly();
        duckSimulatorTwo.quack();

    }
}
