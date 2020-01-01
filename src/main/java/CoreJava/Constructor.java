package CoreJava;

public class Constructor {

    public int number;

    public String word;

    public Constructor(int num, String word){ // sample of constructor
        this.number = num;
        this.word = word;
    }

    public Constructor() {

    }


    public static void main(String[] args) {
        Constructor test = new Constructor(1,"this is a sample of constructor");
        System.out.println(test.number);
        System.out.println(test.word);

        AnotherConstructor test2 = new AnotherConstructor(1,"this is a sample of constructor", 2);
        System.out.println(test2.number);
    }
}

class AnotherConstructor extends Constructor{

    public int anotherNumber;


    public AnotherConstructor(int num, String word) {
        super(num, word);
    }

    public AnotherConstructor(int num, String word, int anotherNumber){
        super();
        this.word = word;
        this.number = num;
        this.anotherNumber = anotherNumber;

    }
}