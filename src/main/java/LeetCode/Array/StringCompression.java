package LeetCode.Array;

import java.util.Arrays;

public class StringCompression {
    public static int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        String s = new String();
        char head = chars[0];
        int count = 0;
        for (char c : chars) {
            if (c == head) {
                count++;
            } else {
                s += head;
                if (count != 1)
                    s += count;
                head = c;
                count = 1;
            }
        }

        s += head;
        if (count != 1)
            s += count;
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {

            chars[i] = s.charAt(i);
        }

        return s.length();
    }

    public static int compress2(char[] chars) {
        int ans = 0; // keep track of current position in compressed array
    
        // iterate through input array using i pointer
        for (int i = 0; i < chars.length;) {
          final char letter = chars[i]; // current character being compressed
          int count = 0; // count of consecutive occurrences of letter
    
          // count consecutive occurrences of letter in input array
          while (i < chars.length && chars[i] == letter) {
            count++;
            i++;
          }
    
          // write letter to compressed array
          chars[ans] = letter;
          ans++;
    
          // if count is greater than 1, write count as string to compressed array
          if (count > 1) {
            // convert count to string and iterate over each character in string
            for (final char c : String.valueOf(count).toCharArray()) {
              chars[ans] = c;
              ans++;
            }
          }
        }
    
        // return length of compressed array
        return ans;
      }

    public static void main(String[] args) {
        // char[] chars = { 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c' };
        char[] chars = { 'a', 'b',  'c','c' };
        System.out.println(compress2(chars));
        System.out.println(chars);
    }
}
