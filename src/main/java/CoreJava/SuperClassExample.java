package CoreJava;

public class SuperClassExample {


    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike(10);
        mountainBike.methodOne();
        mountainBike.methodOne(10);
        mountainBike.methodTwo();
        mountainBike.methodTwo(mountainBike.getHeight());

        MountainBike anotherMountainBike = new MountainBike("giant",100,10);
        anotherMountainBike.methodOne();
        anotherMountainBike.setModel("dwarf");
        System.out.println(anotherMountainBike.getModel());

        Bike bike = new MountainBike(10);
        bike.methodOne(); // has the same name as mountain bike as the method is override by subclass
        bike.methodTwo();
    }
}

class Bike{
    private int size;
    private String model;
    public Bike(String model, int size){
        this.model = model;
        this.size = size;
    }

    public void methodOne(){
        System.out.println("bike method one");
    }

    static void methodTwo(){
        System.out.println("bike method two");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Bike(){} // no arg constructor

}

class MountainBike extends Bike {
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MountainBike(String model, int size, int height) {
        super(model, size); // always call instructor of super class first
        this.height = height;
    }

    public MountainBike(int height) {
        super();
        this.height = height;
    }

    @Override
    public void methodOne() {
        System.out.println("mountain bike method one");
    }

    // overloading
    public void methodOne(int height){
        System.out.println("mountain bike one over-loading"+height);
    }

    // static method in super class cannot be override, but can create another one with same name
    // but different argument
    public void methodTwo(int height){
        System.out.println("mountain bike method two, the height is " + height);
    }

    public static void methodTwo(){ // hiding the static method in superclass
        System.out.println("mountain bike method two static");
    }
}