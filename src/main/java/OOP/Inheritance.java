package OOP;

public class Inheritance extends Calculation {
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the given numbers:\n"+z);
    }

    @Override
    public void addition(int x, int y){
        z = x + y + 10000;
        System.out.println("The sum of the given numbers and 10000:\n"+z);
        super.addition(x,y);// method of  calculation class
    }

    public static void main(String[] args) {
        int x = 20 , y = 10;
        Inheritance test = new Inheritance();
        test.addition(x,y);
        test.subtraction(x, y);
        test.multiplication(x,y);

        Calculation test2 = new Inheritance(); // can create instance of superclass using subclass as blueprint
        test2.addition(x,y);
        test2.subtraction(x, y);
//        test2.multiplication(x,y); This program will throw a compile time error since test2's reference type Calculation doesn't have a method by the name of multiplication.

//        Inheritance test3 = new Calculation(); // Compile wrong, can't

    }
}

class Calculation{
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers:\n"+z);
    }

    public void subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers:\n"+z);
    }
}
