package CoreJava;

public class InterfaceExample implements PrintString,AnotherPrintString{



    public static void main(String[] args) {
//        PrintString printString = new PrintString();

        InterfaceExample interfaceExample = new InterfaceExample();
        interfaceExample.printAbstract();
        interfaceExample.printDefault();
        interfaceExample.anotherPrintAbstract();
        PrintString.printStatic();
    }

    @Override
    public void printAbstract() {
        System.out.println("override abstract method");
    }

    @Override
    public void printDefault(){
        System.out.println("print updated default method");
    }


    @Override
    public void anotherPrintAbstract() {
        System.out.println("override another abstract method");
    }
}

interface PrintString{
    void printAbstract();

    default void printDefault(){
        System.out.println("print default method");
    }

    static void printStatic(){
        System.out.println("print static method");
    }
}

interface AnotherPrintString{
    void anotherPrintAbstract();
}