package LeetCode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        /**** method 1 horizontal scanning ****/

//        // if the string array is empty, then there is no prefix
//        if(strs.length == 0 || strs == null) return "";
//
//        // set the prefix to be the fist string in string array
//        String prefix = strs[0];
//
//        for (int i = 1; i < strs.length; i++)
//
//            // String indexOf() : This method returns the index within this string of the first occurrence of
//            // the specified character or -1, if the character does not occur.
//            while (strs[i].indexOf(prefix) != 0) {
//                // if the character doesn't occur, remove the last character of prefix and retry
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;

        /**** method 2 vertical scanning ****/
        // since only the substring start at the head of string count, could use vertical scanning
        // if the string array is empty, then there is no prefix
        if(strs.length == 0 || strs == null) return "";

        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);// if this return executed then the process is over
            }
        }
        return strs[0]; // if executed, that means the all strings in the array are duplicated
    }

    public static void main(String[] args) {
        String[] strs = {"flower","f","foot"};
        System.out.println(longestCommonPrefix(strs));
    }
}
