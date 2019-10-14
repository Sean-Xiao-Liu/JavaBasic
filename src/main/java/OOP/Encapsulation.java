package OOP;

public class Encapsulation extends number{
    @Override
    public int getNumber(){
        return 100;
    }

    public static void main(String[] args) {
        number test = new Encapsulation();
        test.setNumber(10);
        System.out.println("get number\t"+test.getNumber());

    }
}

class number{
    private int number;

    //getter
    public int getNumber(){
        return this.number;
    }

    //setter
    public void setNumber(int number){
        this.number = number;
    }

}
