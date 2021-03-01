package CoreJava;

public class ExceptionExample {

    public static void exceptionCreator() throws ArrayIndexOutOfBoundsException,DoubleCheckIndexException{
        int[] array = new int[5];
        try{

            for(int i = 0 ; i < 7 ;i++){
                array[i] = i;
            }
            throw new DoubleCheckIndexException();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());


        } catch (DoubleCheckIndexException e){
            e.getMessage();
        } finally {
            System.out.println("The exception is known");
        }
    }

    public static void main(String[] args) {
        exceptionCreator();
    }
}

// create a runtime exception
// to create a compile time exception, let the class extend the Exception class
class DoubleCheckIndexException extends RuntimeException{ // let the custom exception extends the Exception class

    // then create constructors for the custom exception
    public DoubleCheckIndexException() {
        System.out.println("Double Check Index of Array");
    }

    public DoubleCheckIndexException(String message) {
        super(message);
    }

}