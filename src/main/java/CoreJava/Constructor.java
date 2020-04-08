package CoreJava;

public class Constructor {

    public int number;

    public String word;

    public Constructor(int num, String word) { // sample of constructor
        this.number = num;
        this.word = word;
    }

    // add another constructor to the class
    // a class can have more than one constructor, invoke one as needed when initialize the object
    public Constructor() {
//        this.number = 10000;
        this.word = "this is constructor without argument";

    }


    public static void main(String[] args) {
        Constructor test = new Constructor(1, "this is a sample of constructor");
        Constructor test3 = new Constructor();
        System.out.println(test.number);
        System.out.println(test.word);
        System.out.println(test3.number);
        System.out.println(test3.word);

        AnotherConstructor test2 = new AnotherConstructor(1111, "this is a sample of sub constructor", 2);
        System.out.println(test2.number);
        System.out.println(test2.word);
        System.out.println(test2.anotherNumber);
        AnotherConstructor test4 = new AnotherConstructor();
        System.out.println(test4.word);
        System.out.println(test4.number);
        System.out.println(test4.anotherNumber);
    }
}

class AnotherConstructor extends Constructor {

    public int anotherNumber;


    public AnotherConstructor() {
        super(); // invoke the non-argument constructor
        this.anotherNumber = 333;
    }

    public AnotherConstructor(int num, String word, int anotherNumber) {
//        super();
        this.word = super.word; // will take the word of super constructor
        this.number = super.number;
        this.anotherNumber = anotherNumber;

    }
}