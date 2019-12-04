package DataStructure;

//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

public class BackTracking {

    public static void permute(String str,int h,int t){
        if( h == t) {
            System.out.println(str);
        } else {
            for (int i = h; i <= t; i++)
            {
                str = swap(str,h,i);
                permute(str, h+1, t);
                str = swap(str,h,i);
            }
        }
    }


    public static String swap(String a, int i, int j) // switch the char on the position of i and j
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String text = "123";
        int length = text.length();
        permute(text,0,length-1);
    }
}
