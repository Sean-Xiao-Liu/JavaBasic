package CoreJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static String replaceMoreThanOneSpaces(String string){
//        String pattern = "  ";
        String pattern = " +"; // n+ Matches any string that contains at least one n,it match more than one spaces
        string = string.replaceAll(pattern," ");
        return string;

    }

    /**
     *
     * @param string
     * @return
     */
    public static String[] splitBySpaces(String string){
        String pattern = " +";
        String[] strings = string.split(pattern);
        return strings;
    }



    public static void main(String[] args) {
        System.out.println(replaceMoreThanOneSpaces("Two              spaces"));
        String[] strings = splitBySpaces("One Two   Three       Four");
        for(String s:strings){
            System.out.println(s);
        }
    }
}
