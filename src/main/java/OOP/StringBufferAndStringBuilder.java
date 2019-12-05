package OOP;

public class StringBufferAndStringBuilder {

    public static void main(String[] args) {
        String string1 = "string";
        String string2 = "string";
        System.out.println(string1.equals(string2)); // return true since String override the equals()

        StringBuffer stringBuffer1 = new StringBuffer("string");
        System.out.println(string1.equals(stringBuffer1)); // return false

        System.out.println(string1.equals(stringBuffer1.toString())); //return true

        StringBuilder stringBuilder1 = new StringBuilder("string");
        System.out.println(string1.equals(stringBuilder1)); // return false

        System.out.println(string1.equals(stringBuilder1.toString())); // return true

        StringBuffer stringBuffer2 = new StringBuffer("string");
        System.out.println(stringBuffer1.toString().equals(stringBuffer2.toString()));// true
    }
}