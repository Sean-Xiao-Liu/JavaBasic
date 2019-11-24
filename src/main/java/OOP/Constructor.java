package OOP;

public class Constructor {

    public int number;

    public String word;

    public Constructor(int num, String word){ // sample of constructor
        this.number = num;
        this.word = word;
    }


    public static void main(String[] args) {
        Constructor test = new Constructor(1,"this is a sample of constructor");
        System.out.println(test.number);
        System.out.println(test.word);
    }
}

